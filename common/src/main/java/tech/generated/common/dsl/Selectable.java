package tech.generated.common.dsl;

import java.util.Collection;

public interface Selectable<T> {
    public Collection<Selector> selectors();

    public <S extends Selector> T select(S selector);
}
