package tech.generated.common.engine.spi.summner.dsl;

import tech.generated.common.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

class Configuration implements tech.generated.common.dsl.Configuration {

    private final Collection<InstanceBuilder> builders = new ArrayList<>();

    private final Collection<Filler> fillers = new ArrayList<>();

    private final Dsl dsl;

    Configuration(Dsl dsl) {
        Objects.requireNonNull(dsl);
        this.dsl = dsl;
    }

    @Override
    public <T> tech.generated.common.dsl.InstanceBuilder instanceBuilder(Function<Context<?>, T> function) {
        Objects.requireNonNull(function);
        return this.instanceBuilder(this.dsl.instanceBuilder(function));
    }

    @Override
    public <T> InstanceBuilder instanceBuilder(tech.generated.common.dsl.InstanceBuilder instanceBuilder) {
        Objects.requireNonNull(instanceBuilder);
        if (!(instanceBuilder instanceof InstanceBuilder)) {
            throw new IllegalArgumentException("Argument is not instance of " + InstanceBuilder.class);
        } else {
            this.builders.add((InstanceBuilder) instanceBuilder);
            return (InstanceBuilder) instanceBuilder;
        }
    }

    @Override
    public <T> Filler filler(BiFunction<Context<?>, T, T> function) {
        Objects.requireNonNull(function);
        return this.filler(this.dsl.filler(function));
    }

    @Override
    public <T> Filler filler(tech.generated.common.dsl.Filler filler) {
        Objects.requireNonNull(filler);
        if (!(filler instanceof Filler)) {
            throw new IllegalArgumentException("Argument is not instance of " + Filler.class);
        } else {
            this.fillers.add((Filler) filler);
            return (Filler) filler;
        }
    }

    public tech.generated.common.engine.spi.summner.Configuration build() {

        return null;
    }

    private void process(InstanceBuilder instanceBuilder) {

    }
}
