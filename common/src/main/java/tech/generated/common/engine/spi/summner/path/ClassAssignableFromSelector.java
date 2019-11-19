package tech.generated.common.engine.spi.summner.path;

import tech.generated.common.Context;
import tech.generated.common.Constants;
import tech.generated.common.path.Selector;
import tech.generated.common.util.Util;

public class ClassAssignableFromSelector<C extends Class<?>> extends CommonValueMatchSelector<C> implements AsBoxed<ClassAssignableFromSelector<C>> {

    public ClassAssignableFromSelector(String name, Selector<Context<?>> parent, C value) {
        this(name, parent, Constants.METRICS_UNIT, value);
    }

    public ClassAssignableFromSelector(String name, Selector<Context<?>> parent, long metrics, C value) {
        super(name, parent, metrics, (left, right) -> left.isAssignableFrom(right.clazz()), value);
    }

    @Override
    public ClassAssignableFromSelector<C> boxed() {
        return new ClassAssignableFromSelector(this.name() + ".boxed", this.next(), this.metrics(), Util.getDual(this.getValue()));
    }
}
