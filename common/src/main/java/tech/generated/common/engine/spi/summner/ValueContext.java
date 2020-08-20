package tech.generated.common.engine.spi.summner;

import tech.generated.common.Bindings;
import tech.generated.common.Context;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.engine.reflect.Accessor;
import tech.generated.common.path.Path;

public abstract class ValueContext<T> implements Context<T>, Accessor<T> {

    private final Context<?> parent;

    private final Bindings bindings;

    private final GeneratedEngine generatedEngine;

    private boolean isActiveted;

    protected ValueContext(Bindings parentBindings, GeneratedEngine generatedEngine) {
        this.parent = null;
        this.bindings = parentBindings != null ? Bindings.bindings(parentBindings) : Bindings.bindings();
        this.generatedEngine = generatedEngine;
        this.isActiveted = false;
    }

    protected ValueContext(Context<?> parent) {
        this.parent = parent;
        this.bindings = parent != null ? Bindings.bindings(parent.getBindings()) : Bindings.bindings();
        this.generatedEngine = parent.getGeneratedEngine();
        this.isActiveted = false;
    }

    public boolean isActiveted() {
        return isActiveted;
    }

    public void setActiveted(boolean activeted) {
        isActiveted = activeted;
    }

    @Override
    public Bindings getBindings() {
        return this.bindings;
    }

    @Override
    public tech.generated.common.GeneratedEngine getGeneratedEngine() {
        return this.generatedEngine;
    }

    @Override
    public Path<?, ? extends Context<T>> parent() {
        return (Path<?, ? extends Context<T>>) this.parent;
    }
}
