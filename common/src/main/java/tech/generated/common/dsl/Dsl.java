package tech.generated.common.dsl;

import tech.generated.common.Context;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface Dsl extends Strictable, NonStrictable, Pathable {

    public <T> InstanceBuilder instanceBuilder(Function<Context<?>, T> function);

    public <T> Filler filler(BiFunction<Context<?>, T, T> function);

    public Configuration configuration();
}
