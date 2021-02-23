package tech.generated.loly.context;

import tech.generated.Bindings;

import java.util.Objects;

public class ObjectContext<T> extends ComplexContext<T> implements tech.generated.ObjectContext<T> {

    private final Class<T> clazz;

    private T object;

    public ObjectContext(Bindings bindings, Class<T> clazz) {
        super(bindings);
        this.clazz = Objects.requireNonNull(clazz);
    }

    @Override
    public Class<T> clazz() {
        return this.clazz;
    }

    @Override
    public T node() {
        return this.object;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public T get() {
        return this.object;
    }

    @Override
    public void set(T value) {
        this.object = value;
    }
}
