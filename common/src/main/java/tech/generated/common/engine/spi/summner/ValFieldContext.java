package tech.generated.common.engine.spi.summner;

import tech.generated.common.path.Path;
import tech.generated.common.util.Util;

import java.lang.reflect.Field;
import java.util.stream.Stream;

class ValFieldContext<T> extends ValueContext<T> {

    private final Field field;

    ValFieldContext(ComplexContext<?> parent, Field field) {
        super(parent);
        this.field = field;

        parent.addMember(this);
    }


    @Override
    public T get() {
        return Util.getFieldValue(this.field, this.parent().node());
    }

    @Override
    public void set(T value) {
        Util.setFieldValue(this.field, this.parent().node(), value);
    }

    @Override
    public Class<T> clazz() {
        return (Class<T>) this.field.getType();
    }

    @Override
    public T node() {
        return this.get();
    }

    @Override
    public String name() {
        return this.field.getName();
    }

    @Override
    public Stream<Path<?, ?>> child() {
        return Stream.empty();
    }
}
