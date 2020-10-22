package tech.generated.common.engine.spi.summner.dsl;

import tech.generated.common.dsl.Selectable;
import tech.generated.common.dsl.Selector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

abstract class AbstractSelectable<T> implements Selectable<T> {
    private final Collection<Selector> selectors = new ArrayList<>();

    @Override
    public Collection<Selector> selectors() {
        return Collections.unmodifiableCollection(this.selectors);
    }

    @Override
    public <S extends Selector> T select(S selector) {
        Objects.requireNonNull(selector);

        this.selectors.add(selector);

        return (T) this;
    }
}
