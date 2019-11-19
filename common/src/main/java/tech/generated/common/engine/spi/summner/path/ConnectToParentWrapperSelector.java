package tech.generated.common.engine.spi.summner.path;

import tech.generated.common.Context;
import tech.generated.common.path.Selector;

import java.util.Objects;
import java.util.stream.Stream;

public class ConnectToParentWrapperSelector implements Selector<Context<?>> {

    protected final Selector<Context<?>> down;

    protected final Selector<Context<?>> up;

    public static ConnectToParentWrapperSelector of(Selector<Context<?>> down, Selector<Context<?>> up) {
        final ConnectToParentWrapperSelector result;

        if (down instanceof AsBoxed) {
            result = new BoxedConnectToParentWrapperSelector(down, up);
        } else {
            result = new ConnectToParentWrapperSelector(down, up);
        }

        return result;
    }

    private ConnectToParentWrapperSelector(Selector<Context<?>> down, Selector<Context<?>> up) {
        Objects.requireNonNull(down);

        this.down = down.chain().reduce((l, r) -> r).get();
        this.up = up;
    }

    @Override
    public Stream<Selector<Context<?>>> chain() {
        return Stream.concat(this.down.chain(), this.up.chain());
    }

    @Override
    public String name() {
        return this.down.name();
    }

    @Override
    public Selector next() {
        return this.up;
    }

    @Override
    public long metrics() {
        return this.down.metrics() + this.up.metrics();
    }

    @Override
    public boolean test(Context<?> context) {
        return this.down.test(context) && this.up.test(context);
    }

    @Override
    public ConnectToParentWrapperSelector clone() throws CloneNotSupportedException {
        final ConnectToParentWrapperSelector clone = (ConnectToParentWrapperSelector) super.clone();

        return clone;
    }

    private static class BoxedConnectToParentWrapperSelector extends ConnectToParentWrapperSelector implements AsBoxed {

        private BoxedConnectToParentWrapperSelector(Selector<Context<?>> down, Selector<Context<?>> up) {
            super(down, up);
        }

        @Override
        public Object boxed() {
            return new BoxedConnectToParentWrapperSelector(((AsBoxed<Selector>) this.down).boxed(), this.up);
        }
    }
}
