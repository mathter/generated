package tech.generated.common.engine.spi.summner.path;


import tech.generated.common.Context;
import tech.generated.common.Constants;
import tech.generated.common.path.Selector;

import java.util.Objects;

public class NameEqualsSelector extends CommonValueMatchSelector<String> {

    public NameEqualsSelector(String name, Selector<Context<?>> parent, String value) {
        this(name, parent, Constants.METRICS_UNIT, value);
    }

    public NameEqualsSelector(String name, Selector<Context<?>> parent, long metrics, String value) {
        super(name, parent, metrics, (name1, path) -> Objects.equals(name1, path.name()), value);
    }
}
