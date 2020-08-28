package tech.generated.common.engine.spi.summner;

import tech.generated.common.Context;
import tech.generated.common.FillerFactory;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.InstanceBuilderFactory;
import tech.generated.common.NewInstanceException;
import tech.generated.common.engine.reflect.Accessor;
import tech.generated.common.util.Util;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class DefaultFiller<T> implements Function<T, T> {
    private final ValueContext<T> context;

    private final Collection<String> skippedFields = new HashSet<>();

    public DefaultFiller(ValueContext<T> context) {
        this.context = context;
    }

    @Override
    public T apply(T object) {
        if (!this.context.isActiveted()) {
            if (object != null && !Util.isSimple(object.getClass())) {
                this.fillObject(object);
            }

            this.context.setActiveted(true);
        }

        return object;
    }

    private void fillObject(T object) {
        this
                .prepareClassHierarchy(object.getClass())
                .forEach((c) -> fill(c, object));
    }

    private <T> void fill(Class<T> clazz, Object object) {
        this
                .preapreFieldsForFilling(clazz)
                .forEach(this::fill);
    }

    private <F> Context<F> fill(Accessor<F> accessor) throws NewInstanceException {
        final GeneratedEngine engine = this.context.getGeneratedEngine();
        final InstanceBuilderFactory instanceBuilderFactory = engine.instanceBuilderFactory();
        final FillerFactory fillerFactory = engine.fillerFactory();

        final Supplier<F> instanceBuilder = instanceBuilderFactory.builder((ValueContext<F>) accessor);
        F object = instanceBuilder.get();

        accessor.set(object);
        final Function<F, F> filler = fillerFactory.filler((ValueContext<F>) accessor);
        object = filler.apply(object);
        accessor.set(object);

        return (Context<F>) accessor;
    }

    private Stream<Accessor<?>> preapreFieldsForFilling(Class<?> clazz) {
        return this
                .prepareActualFields(clazz)
                .map(f -> f.getType().isPrimitive()
                        ? new ValFieldContext((ComplexContext) this.context, f)
                        : new RefFieldContext((ComplexContext) this.context, f));
    }

    private Stream<Field> prepareActualFields(Class<?> clazz) {
        return this
                .prepareDeclaredFields(clazz)
                .filter(f -> !DefaultFiller.this.skippedFields.contains(f.getName()));
    }

    private Stream<Field> prepareDeclaredFields(Class<?> clazz) {
        return Arrays
                .asList(clazz.getDeclaredFields())
                .stream();
    }

    private static Stream<Class<?>> prepareClassHierarchy(Class<?> clazz) {
        Deque<Class<?>> stack = new ArrayDeque<>(5);

        do {
            stack.push(clazz);
        } while ((clazz = clazz.getSuperclass()) != null);

        return stack.stream();
    }

    /**
     * Add skipped field.
     *
     * @param name name of the field.
     */
    public void addSkippedField(String name) {
        if (name != null) {
            this.skippedFields.add(name);
        } else {
            throw new IllegalArgumentException("name can't be null!");
        }
    }

    /**
     * Remove skipped field.
     *
     * @param name name of the field.
     */
    public void removeSkippedField(String name) {
        if (name != null) {
            this.skippedFields.remove(name);
        } else {
            throw new IllegalArgumentException("name can't be null!");
        }
    }
}
