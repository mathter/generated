package tech.generated.common.engine.spi.summner.dsl;

import tech.generated.common.Context;

import java.util.function.BiFunction;

class Filler<T> extends AbstractSelectable<tech.generated.common.dsl.Filler> implements tech.generated.common.dsl.Filler {
    private final BiFunction<Context<?>, T, T> function;

    Filler(BiFunction<Context<?>, T, T> function) {
        this.function = function;
    }
}
