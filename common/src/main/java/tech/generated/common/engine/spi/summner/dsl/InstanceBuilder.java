package tech.generated.common.engine.spi.summner.dsl;

import tech.generated.common.Context;

import java.util.function.Function;

class InstanceBuilder extends AbstractSelectable<tech.generated.common.dsl.InstanceBuilder> implements tech.generated.common.dsl.InstanceBuilder {

    private final Function<Context<?>, ?> function;

    public InstanceBuilder(Function<Context<?>, ?> function) {
        this.function = function;
    }

    public Function<Context<?>, ?> getFunction() {
        return function;
    }
}
