package tech.generated.common.engine.spi.summner;

import tech.generated.common.Bindings;
import tech.generated.common.Context;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.path.Path;

import java.util.stream.Stream;

class StartContext<T> implements Context<T> {

    private static final String NAME = "<NAME>";

    private final Bindings bindings;

    private final Class<T> clazz;

    private final GeneratedEngine generatedEngine;

    private Context<?> child;

    public StartContext(GeneratedEngine generatedEngine, Class<T> clazz, Bindings bindings) {
        this.generatedEngine = generatedEngine;
        this.clazz = clazz;
        this.bindings = bindings != null ? bindings : Bindings.bindings(null);
        this.child = null;
    }

    void setChild(Context<?> child) {
        this.child = child;
    }

    @Override
    public Bindings getBindings() {
        return this.bindings;
    }

    @Override
    public Class<T> clazz() {
        return this.clazz;
    }

    @Override
    public T node() {
        return null;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public Path<?, ? extends Context<T>> parent() {
        return null;
    }

    @Override
    public Stream<Path<?, ?>> child() {
        return this.child != null ? Stream.of(this.child) : Stream.empty();
    }
}
