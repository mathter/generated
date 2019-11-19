package tech.generated.common.engine.spi.summner;

import tech.generated.common.Bindings;
import tech.generated.common.Context;

public class ObjectContext<T> extends ComplexContext<T, Object> {
    private T object;

    private final Class<T> clazz;

    public ObjectContext(Class<T> clazz, Bindings bindings) {
        super(bindings);
        this.clazz = clazz;
    }

    public ObjectContext(Class<T> clazz, Context<?> parent) {
        super((Context<Object>) parent);
        this.clazz = clazz;
    }

    @Override
    public T get() {
        return this.object;
    }

    @Override
    public void set(T value) {
        this.object = value;
    }

    @Override
    public Class<T> clazz() {
        return this.object != null ? (Class<T>) this.object.getClass() : this.clazz;
    }

    @Override
    public T node() {
        return this.object;
    }

    @Override
    public String name() {
        return "<ROOT>";
    }
}
