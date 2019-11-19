package tech.generated.common.engine.spi.summner.path;

import tech.generated.common.Context;
import tech.generated.common.path.Path;
import tech.generated.common.path.Selector;

public class SkipNameSelector extends AbstractSelector {

    private final int count;

    public SkipNameSelector(String name, Selector<Context<?>> parent, int count) {
        this(name, parent, count, count);
    }

    public SkipNameSelector(String name, Selector<Context<?>> parent, long metrics, int count) {
        super(name, parent, metrics);

        if (count < 0) {
            throw new IllegalArgumentException("count can't be less then zero!");
        }

        this.count = count;
    }

    @Override
    public boolean test(Context<?> path) {
        Path<?, ?> p = path;

        for (int i = 1; i < count && p != null; i++, p = p.parent()) ;

        return p != null && super.test(path);
    }
}
