package tech.generated.common.engine.spi.summner.dsl;

import tech.generated.common.dsl.NonStrict;
import tech.generated.common.dsl.Path;
import tech.generated.common.dsl.Selector;
import tech.generated.common.dsl.Strict;

import java.util.stream.Stream;

abstract class AbstractSelector implements Selector {
    protected final Selector prev;

    protected Selector next;

    protected AbstractSelector(Selector prev) {
        this.prev = prev;
    }

    @Override
    public <T> NonStrict<T> nonstrictable(Class<T> clazz) {
        this.checkClassSelector();
        this.next = new tech.generated.common.engine.spi.summner.dsl.NonStrict(clazz, this);
        return (NonStrict<T>) this.next;
    }

    @Override
    public Path path(String path) {
        this.next = new tech.generated.common.engine.spi.summner.dsl.Path(path, this);
        return (Path) this.next;
    }

    @Override
    public <T> Strict<T> strict(Class<T> clazz) {
        this.checkClassSelector();
        this.next = new tech.generated.common.engine.spi.summner.dsl.Strict(clazz, this);
        return (Strict<T>) this.next;
    }

    @Override
    public Stream<Selector> up() {
        final Stream<Selector> result;

        if (this.prev != null) {
            result = Stream.concat(Stream.of(this), this.prev.up());
        } else {
            result = Stream.of(this);
        }

        return result;
    }

    protected void checkClassSelector() {
        this
                .up()
                .filter(e -> e instanceof Strict || e instanceof NonStrict).findAny()
                .ifPresent(e -> {
                            throw new IllegalStateException("Can't create class selector as chain of the another class selector!");
                        }
                );
    }
}
