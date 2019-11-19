package tech.generated.common.engine.spi.summner.path;

import tech.generated.common.Context;
import tech.generated.common.engine.spi.summner.ObjectContext;
import tech.generated.common.path.Selector;

public class RootMatchSelector extends AbstractSelector {

    public RootMatchSelector(String name, Selector<Context<?>> parent) {
        this(name, parent, 1);
    }

    public RootMatchSelector(String name, Selector<Context<?>> parent, long metrics) {
        super(name, parent, metrics);
    }

    @Override
    public boolean test(Context<?> path) {
        return path.getClass().equals(ObjectContext.class) && super.test(path);
    }
}
