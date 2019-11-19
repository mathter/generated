package tech.generated.common.engine.spi.summner.path;


import tech.generated.common.Context;
import tech.generated.common.path.Selector;

public class RoutingSelector extends AbstractSelector {

    private final Selector<Context<?>> horizontal;

    public RoutingSelector(String name, Selector<Context<?>> next, long metrics, Selector<Context<?>> horizontal) {
        super(name, next, metrics);
        this.horizontal = horizontal;
    }

    @Override
    public boolean test(Context<?> context) {
        return (this.horizontal != null && this.horizontal.test(context)) && super.test(context);
    }
}
