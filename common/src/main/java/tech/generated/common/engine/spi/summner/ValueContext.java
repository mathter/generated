package tech.generated.common.engine.spi.summner;

import tech.generated.common.Bindings;
import tech.generated.common.Context;
import tech.generated.common.engine.reflect.Accessor;
import tech.generated.common.path.Path;

public abstract class ValueContext<T, P> implements Context<T>, Accessor<T> {

    private final Context<P> parent;

    private final Bindings bindings;

    private boolean isActiveted;

    protected ValueContext(Bindings parentBindings) {
        this.parent = null;
        this.bindings = parentBindings != null ? Bindings.bindings(parentBindings) : Bindings.bindings();
        this.isActiveted = false;
    }

    protected ValueContext(Context<P> parent) {
        this.parent = parent;
        this.bindings = parent != null ? Bindings.bindings(parent.getBindings()) : Bindings.bindings();
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
    public Path<?, ? extends Context<T>> parent() {
        return (Path<?, ? extends Context<T>>) this.parent;
    }
}
