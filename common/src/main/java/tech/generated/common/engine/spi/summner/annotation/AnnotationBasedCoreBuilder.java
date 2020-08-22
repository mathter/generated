package tech.generated.common.engine.spi.summner.annotation;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.generated.common.Context;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.annotation.Filler;
import tech.generated.common.annotation.ForClass;
import tech.generated.common.annotation.InstanceBuilder;
import tech.generated.common.engine.spi.summner.Core;
import tech.generated.common.engine.spi.summner.DefaultFiller;
import tech.generated.common.engine.spi.summner.NameGenerator;
import tech.generated.common.engine.spi.summner.ValueContext;
import tech.generated.common.engine.spi.summner.path.ClassAssignableFromSelector;
import tech.generated.common.engine.spi.summner.path.ClassEqualsSelector;
import tech.generated.common.engine.spi.summner.path.ConnectToParentWrapperSelector;
import tech.generated.common.path.Selector;
import tech.generated.common.util.Util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AnnotationBasedCoreBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(AnnotationBasedCoreBuilder.class);

    private static final Predicate<Method> METHOD_PREDICATE_INSTANCE_BUILDER;

    private static final Predicate<Method> METHOD_PREDICATE_FILLER;

    private final GeneratedEngine generatedEngine;

    public AnnotationBasedCoreBuilder(GeneratedEngine generatedEngine) {
        this.generatedEngine = generatedEngine;
    }

    public Core build(Object configuration) {
        final CoreImpl core = new CoreImpl();
        final AnnotationListener listener = new AnnotationListener() {
            @Override
            public void fireInstanceBuilder(Selector<Context<?>> selector, Function<Context<?>, ?> function) {
                core.add(selector, function);
            }

            @Override
            public <T> void fireFiller(Selector<Context<?>> selector, BiFunction<Context<?>, ?, ?> function) {
                core.add(selector, function);
            }
        };

        this
                .instancebuilders(configuration)
                .forEach(p -> listener.fireInstanceBuilder(p.getLeft(), p.getRight()));
        this
                .fillers(configuration)
                .forEach(p -> listener.fireFiller(p.getLeft(), p.getRight()));

        return core;
    }

    private Stream<Pair<Selector<Context<?>>, Function<Context<?>, ?>>> instancebuilders(Object configuration) {
        return this
                .streamOfMethods(configuration.getClass(), METHOD_PREDICATE_INSTANCE_BUILDER)
                .map(m -> this.instanceBuilder(configuration, m));
    }

    private Pair<Selector<Context<?>>, Function<Context<?>, ?>> instanceBuilder(Object configuration, Method method) {
        final Function<Context<?>, ?> function;

        if (method.getAnnotation(InstanceBuilder.class) != null) {
            Class<?>[] paramTypes = method.getParameterTypes();

            if (Supplier.class.isAssignableFrom(method.getReturnType())) {
                if (paramTypes.length == 0) {
                    function = (context) -> {
                        try {
                            return ((Supplier) method.invoke(configuration)).get();
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    };
                } else if (paramTypes.length == 1 && Context.class.isAssignableFrom(paramTypes[0])) {
                    function = (context) -> {
                        try {
                            return ((Supplier) method.invoke(configuration, context)).get();
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    };
                } else {
                    throw new IllegalArgumentException("Method " + method + "must have signature 'Function function()' or 'Function function(" + Context.class + ")'!");
                }
            } else {
                if (paramTypes.length == 0) {
                    function = (context -> {
                        try {
                            return Util.invoke(configuration, method);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                } else if (paramTypes.length == 1 && Context.class.isAssignableFrom(paramTypes[0])) {
                    function = (context -> {
                        try {
                            return Util.invoke(configuration, method, context);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                } else {
                    throw new IllegalArgumentException("Method " + method + "must have signature '? function()' or '? function(" + Context.class + ")'!");
                }
            }
        } else {
            throw new IllegalArgumentException("Method " + method + " maust be annotaited by " + InstanceBuilder.class + " annotation!");
        }

        return Pair.of(this.selectors(configuration, method).findFirst().get(), function);
    }

    private Stream<Pair<Selector<Context<?>>, BiFunction<Context<?>, ?, ?>>> fillers(Object configuration) {
        return this
                .streamOfMethods(configuration.getClass(), METHOD_PREDICATE_FILLER)
                .map(m -> this.filler(configuration, m));
    }

    private Pair<Selector<Context<?>>, BiFunction<Context<?>, ?, ?>> filler(Object configuration, Method method) {
        final BiFunction<Context<?>, ?, ?> function;

        if (method.getAnnotation(InstanceBuilder.class) == null) {
            Class<?>[] paramTypes = method.getParameterTypes();

            if (Function.class.isAssignableFrom(method.getReturnType())) {
                if (paramTypes.length == 0) {
                    function = (context, object) -> ((Function) Util.invoke(configuration, method))
                            .apply(object);
                } else if (paramTypes.length == 1 && Context.class.isAssignableFrom(paramTypes[0])) {
                    function = (context, object) -> ((Function) Util.invoke(configuration, method, context))
                            .apply(object);
                } else {
                    throw new IllegalArgumentException("Method " + method + "must have signature '? function()' or '? function(" + Context.class + ")'!");
                }
            } else {
                if (paramTypes.length > 0 && paramTypes.length < 3) {
                    if (paramTypes.length == 1) {
                        function = (context, object) -> {
                            try {
                                return Util.invoke(configuration, method, object);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        };
                    } else {
                        if (Context.class.isAssignableFrom(paramTypes[0])) {
                            function = (context, object) -> {
                                try {
                                    return Util.invoke(configuration, method, context, object);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            };
                        } else if (Context.class.isAssignableFrom(paramTypes[1])) {
                            function = (context, object) -> {
                                try {
                                    return Util.invoke(configuration, method, object, context);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            };
                        } else {
                            throw new IllegalArgumentException("Method " + method + " must have signature: '? function(? object, " + Context.class + " context)' or '? function(" + Context.class + " context, ? object)'!");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Method " + method + " must have signature: '? function(? object, " + Context.class + " context)' or '? function(" + Context.class + " context, ? object)'!");
                }
            }
        } else {
            if (method.getAnnotation(InstanceBuilder.class).simple()) {
                function = (context, object) -> object;
            } else {
                function = (context, object) -> new DefaultFiller((ValueContext) context).apply(object);
            }
        }

        return Pair.of(this.selectors(configuration, method).findFirst().get(), function);
    }

    private Stream<Selector<Context<?>>> selectors(Object configuration, Method method) {
        return Stream
                .of(Stream
                        .of(method.getAnnotations())
                        .filter(a -> !(a instanceof InstanceBuilder || a instanceof Filler || a instanceof ForClass))
                        .map(a -> AnnotationProcessor
                                .get(a)
                                .map(p -> p.process(this, configuration, method, a))
                                .orElse(null))
                        .filter(e -> e != null && e instanceof Selector)
                        .map(e -> (Selector<Context<?>>) e)
                        .reduce(this.getClassSelector(configuration, method), (l, r) -> l != null ? ConnectToParentWrapperSelector.of(l, r) : r)
                );
    }

    private Selector<Context<?>> getClassSelector(Object configuration, Method method) {
        return Optional
                .ofNullable(method.getAnnotation(ForClass.class))
                .map(a -> {
                    final Selector<Context<?>> selector;

                    if (a.strict()) {
                        selector = new ClassEqualsSelector(a.name() != null ? a.name() : NameGenerator.nextName(), null, a.metrics(), a.value());
                    } else {
                        selector = new ClassAssignableFromSelector(a.name() != null ? a.name() : NameGenerator.nextName(), null, a.metrics(), a.value());
                    }

                    return selector;
                })
                .orElseGet(() ->
                        (Selector<Context<?>>) new ClassEqualsSelector(NameGenerator.nextName(), null, 1, this.of(method))
                );
    }

    private Class<?> of(Method method) {
        final Class<?> result;

        if (method.getAnnotation(InstanceBuilder.class) != null) {
            result = Optional
                    .of(method.getReturnType())
                    .map(c -> {
                        final Class<?> clazz;

                        if (Supplier.class.isAssignableFrom(c)) {
                            clazz = Util.getSupplierReturnType((Class<Supplier<?>>) c);
                        } else {
                            clazz = c;
                        }

                        return clazz;
                    }).get();
        } else if (method.getAnnotation(Filler.class) != null) {
            result = Optional
                    .of(method.getReturnType())
                    .map(c -> {
                        final Class<?> clazz;

                        if (Function.class.isAssignableFrom(c)) {
                            clazz = Util.getFunctionArgumentType((Class<Function<?, ?>>) c);
                        } else {
                            clazz = Optional
                                    .of(method.getParameterCount())
                                    .map(count -> {
                                        if (count > 0 && count < 3) {
                                            return count == 1 || Context.class.isAssignableFrom(method.getParameterTypes()[1]) ?
                                                    method.getParameterTypes()[0] : method.getParameterTypes()[1];
                                        } else {
                                            throw new IllegalArgumentException("Method " + method + " must have signature: '? function(? object, " + Context.class + " context)' or '? function(" + Context.class + " context, ? object)'!");
                                        }
                                    })
                                    .get();
                        }

                        return clazz;
                    })
                    .get();
        } else {
            throw new IllegalArgumentException("Method " + method + " must be annotated by " + InstanceBuilder.class + " or " + Filler.class + " annotation!");
        }

        return result;
    }

    private Stream<Method> streamOfMethods(Class<?> clazz, Predicate<Method> predicate) {
        Class<?> superClass = clazz.getSuperclass();

        if (superClass != null) {
            return Stream
                    .concat(
                            streamOfMethods(superClass, predicate),
                            Stream.of(clazz.getMethods())
                                    .filter(predicate)
                    );
        } else {
            return Stream.of(clazz.getMethods())
                    .filter(predicate);
        }
    }


    static {
        METHOD_PREDICATE_INSTANCE_BUILDER = method -> {
            final Class<?>[] parameterTypes = method.getParameterTypes();

            return method.getAnnotation(tech.generated.common.annotation.InstanceBuilder.class) != null
                    && Modifier.isPublic(method.getModifiers())
                    && (parameterTypes.length == 0 || (parameterTypes.length == 1 && Context.class.isAssignableFrom(parameterTypes[0])));
        };

        METHOD_PREDICATE_FILLER = method -> {
            final Class<?>[] parameterTypes = method.getParameterTypes();

            return method.getAnnotation(tech.generated.common.annotation.InstanceBuilder.class) != null
                    || (Modifier.isPublic(method.getModifiers())
                    && method.getAnnotation(tech.generated.common.annotation.Filler.class) != null);
        };
    }
}
