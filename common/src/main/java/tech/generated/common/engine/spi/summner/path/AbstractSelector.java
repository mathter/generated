package tech.generated.common.engine.spi.summner.path;

import tech.generated.common.Context;
import tech.generated.common.path.Selector;
import tech.generated.common.util.Util;

abstract class AbstractSelector implements Selector<Context<?>>, Cloneable {

    private final String name;

    private final Selector<Context<?>> next;

    private final long metrics;

    public AbstractSelector(String name, Selector<Context<?>> next, long metrics) {
        if (name == null) {
            throw new IllegalArgumentException("name can't be null!");
        }
        this.name = name;
        this.next = next;
        this.metrics = metrics;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Selector<Context<?>> next() {
        return this.next;
    }

    @Override
    public long metrics() {
        return this.next != null ? this.next.metrics() + this.metrics : this.metrics;
    }

    @Override
    public boolean test(Context<?> path) {
        return this.next == null || this.next.test(path);
    }

    @Override
    public AbstractSelector clone() throws CloneNotSupportedException {
        final AbstractSelector clone = (AbstractSelector) super.clone();

        try {
            Util.setFieldValue(AbstractSelector.class.getField("next"), clone, this.next.clone());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        return clone;
    }
}
