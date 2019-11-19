package tech.generated.common.engine.spi.summner.annotation;

import tech.generated.common.Context;
import tech.generated.common.path.Selector;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface AnnotationListener {
    public void fireInstanceBuilder(Selector<Context<?>> selector, Function<Context<?>, ?> function);

    public <T> void fireFiller(Selector<Context<?>> selector, BiFunction<Context<?>, ?, ?> function);
}
