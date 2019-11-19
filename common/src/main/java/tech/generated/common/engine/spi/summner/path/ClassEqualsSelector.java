package tech.generated.common.engine.spi.summner.path;

import tech.generated.common.Context;
import tech.generated.common.Constants;
import tech.generated.common.path.Selector;
import tech.generated.common.util.Util;

import java.util.Objects;

public class ClassEqualsSelector<C extends Class<?>> extends CommonValueMatchSelector<C> implements AsBoxed<ClassEqualsSelector<C>> {

    public ClassEqualsSelector(String name, Selector parent, C value) {
        this(name, parent, Constants.METRICS_UNIT, value);
    }

    public ClassEqualsSelector(String name, Selector<Context<?>> parent, long metrics, C value) {
        super(name, parent, metrics, (clazz, path) -> Objects.equals(clazz, path.clazz()), value);
    }


    @Override
    public ClassEqualsSelector<C> boxed() {
        return new ClassEqualsSelector(this.name() + ".boxed", this.next(), this.metrics(), Util.getDual(this.getValue()));
    }
}
