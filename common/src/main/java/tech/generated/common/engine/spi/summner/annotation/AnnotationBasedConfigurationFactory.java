package tech.generated.common.engine.spi.summner.annotation;

import org.apache.commons.lang3.tuple.Pair;
import tech.generated.common.Context;
import tech.generated.common.annotation.Filler;
import tech.generated.common.annotation.ForClass;
import tech.generated.common.annotation.InstanceBuilder;
import tech.generated.common.engine.spi.summner.Configuration;
import tech.generated.common.engine.spi.summner.DefaultFiller;
import tech.generated.common.engine.spi.summner.NameGenerator;
import tech.generated.common.engine.spi.summner.ValueContext;
import tech.generated.common.engine.spi.summner.path.ClassAssignableFromSelector;
import tech.generated.common.engine.spi.summner.path.ClassEqualsSelector;
import tech.generated.common.engine.spi.summner.path.ConnectToParentWrapperSelector;
import tech.generated.common.path.Selector;
import tech.generated.common.util.Util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AnnotationBasedConfigurationFactory {
    private static final Predicate<Method> METHOD_PREDICATE_INSTANCE_BUILDER;

    private static final Predicate<Method> METHOD_PREDICATE_FILLER;

    public Configuration build(Object configuration) {
        final ConfigurationImpl core = new ConfigurationImpl();
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
                .methods(configuration.getClass(), METHOD_PREDICATE_INSTANCE_BUILDER)
                .map(m -> this.instanceBuilderWithSelector(configuration, m));
    }

    private Pair<Selector<Context<?>>, Function<Context<?>, ?>> instanceBuilderWithSelector(Object configuration, Method method) {
        final Function<Context<?>, ?> function = this.instanceBuilder(configuration, method);
        final Selector<Context<?>> selector = this.selectors(configuration, method).findFirst().get();

        return Pair.of(selector, function);
    }

    private Function<Context<?>, ?> instanceBuilder(Object configuration, Method method) {
        final Function<Context<?>, ?> function;

        if (method.getAnnotation(InstanceBuilder.class) != null) {
            Class<?>[] types = method.getParameterTypes();

            if (Supplier.class.isAssignableFrom(method.getReturnType())) {
                if (types.length == 0) {
                    function = (context) -> ((Supplier) Util.invoke(configuration, method)).get();
                } else if (types.length == 1 && Context.class.isAssignableFrom(types[0])) {
                    function = (context) -> ((Supplier) Util.invoke(configuration, method, context)).get();
                } else {
                    throw new IllegalArgumentException("Method " + method + "must have signature 'Function function()' or 'Function function(" + Context.class + ")'!");
                }
            } else {
                if (types.length == 0) {
                    function = (context -> Util.invoke(configuration, method));
                } else if (types.length == 1 && Context.class.isAssignableFrom(types[0])) {
                    function = (context -> Util.invoke(configuration, method, context));
                } else {
                    throw new IllegalArgumentException("Method " + method + "must have signature '? function()' or '? function(" + Context.class + ")'!");
                }
            }
        } else {
            throw new IllegalArgumentException("Method " + method + "must have signature '? function()' or '? function(" + Context.class + ")'!");
        }

        return function;
    }

    private Stream<Pair<Selector<Context<?>>, BiFunction<Context<?>, ?, ?>>> fillers(Object configuration) {
        return this
                .methods(configuration.getClass(), METHOD_PREDICATE_FILLER)
                .map(m -> this.fillerWithSelector(configuration, m));
    }

    private Pair<Selector<Context<?>>, BiFunction<Context<?>, ?, ?>> fillerWithSelector(Object configuration, Method method) {
        final BiFunction<Context<?>, ?, ?> function = this.filler(configuration, method);
        final Selector<Context<?>> selector = this.selectors(configuration, method).findFirst().get();

        return Pair.of(selector, function);
    }

    private BiFunction<Context<?>, ?, ?> filler(Object configuration, Method method) {
        final BiFunction<Context<?>, ?, ?> function;

        if (method.getAnnotation(InstanceBuilder.class) == null) {
            Class<?>[] types = method.getParameterTypes();

            if (Function.class.isAssignableFrom(method.getReturnType())) {
                if (types.length == 0) {
                    function = (context, object) -> ((Function) Util.invoke(configuration, method))
                            .apply(object);
                } else if (types.length == 1 && Context.class.isAssignableFrom(types[0])) {
                    function = (context, object) -> ((Function) Util.invoke(configuration, method, context))
                            .apply(object);
                } else {
                    throw new IllegalArgumentException("Method " + method + "must have signature '? function()' or '? function(" + Context.class + ")'!");
                }
            } else {
                if (types.length > 0 && types.length < 3) {
                    if (types.length == 1) {
                        function = (context, object) -> Util.invoke(configuration, method, object);
                    } else {
                        if (Context.class.isAssignableFrom(types[0])) {
                            function = (context, object) -> Util.invoke(configuration, method, context, object);
                        } else if (Context.class.isAssignableFrom(types[1])) {
                            function = (context, object) -> Util.invoke(configuration, method, object, context);
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

        return function;
    }

    private Stream<Selector<Context<?>>> selectors(Object configuration, Method method) {
        return Stream
                .of(Stream
                        .of(method.getAnnotations())
                        .filter(a -> !(a instanceof InstanceBuilder || a instanceof Filler || a instanceof ForClass))
                        .map(a -> SelectorAnnotationProcessor
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
                        selector = new ClassEqualsSelector(
                                a.name() != null ? a.name() : NameGenerator.nextName(),
                                null,
                                method.getAnnotation(InstanceBuilder.class) != null ? Long.MIN_VALUE : a.metrics(),
                                a.value()
                        );
                    } else {
                        selector = new ClassAssignableFromSelector(
                                a.name() != null ? a.name() : NameGenerator.nextName(),
                                null,
                                method.getAnnotation(InstanceBuilder.class) != null ? Long.MIN_VALUE : a.metrics(),
                                a.value());
                    }

                    return selector;
                })
                .orElseGet(() ->
                        (Selector<Context<?>>) new ClassEqualsSelector(
                                NameGenerator.nextName(),
                                null,
                                method.getAnnotation(InstanceBuilder.class) != null ? Long.MIN_VALUE : 0L,
                                this.classOf(method))
                );
    }

    private String getName(ForClass annotation) {
        return annotation.name() != null ? annotation.name() : NameGenerator.nextName();
    }

    private Class<?> classOf(Method method) {
        final Class<?> result;

        if (method.getAnnotation(InstanceBuilder.class) != null) {
            final Type type;

            if ((type = method.getGenericReturnType()) instanceof ParameterizedType
                    && ((ParameterizedType) type).getRawType().equals(Supplier.class)) {
                result = Util.getSupplierReturnType((ParameterizedType) type);
            } else {
                result = (Class<?>) type;
            }
        } else if (method.getAnnotation(Filler.class) != null) {
            final Type type;

            if ((type = method.getGenericReturnType()) instanceof ParameterizedType
                    && ((ParameterizedType) type).getRawType().equals(Function.class)) {
                result = Util.getFunctionArgumentType((ParameterizedType) type);
            } else {
                result = (Class<?>) type;
            }
        } else {
            result = null;
        }

        return result;
    }

    private Stream<Method> methods(Class<?> clazz, Predicate<Method> predicate) {
        Class<?> superClass = clazz.getSuperclass();

        if (superClass != null) {
            return Stream
                    .concat(
                            methods(superClass, predicate),
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
