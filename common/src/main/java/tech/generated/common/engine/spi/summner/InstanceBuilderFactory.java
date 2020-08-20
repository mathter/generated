package tech.generated.common.engine.spi.summner;

import tech.generated.common.Context;
import tech.generated.common.engine.spi.summner.path.AsBoxed;
import tech.generated.common.path.Selector;
import tech.generated.common.util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;

class InstanceBuilderFactory implements tech.generated.common.InstanceBuilderFactory {
    private final GeneratedEngine generatedEngine;

    InstanceBuilderFactory(GeneratedEngine generatedEngine) {
        this.generatedEngine = generatedEngine;
    }

    @Override
    public <T> Supplier<T> builder(Context<T> context) {
        final Collection<Selector<Context<?>>> candidates = new ArrayList<>();

        for (Selector<Context<?>> selector : this.generatedEngine.getCore().instanceBuilderSelectors()) {
            if (selector.test(context)) {
                candidates.add(selector);
            }
        }

        if (Util.isBoxing(context.clazz()) && candidates.isEmpty()) {
            for (Selector<Context<?>> selector : this.generatedEngine.getCore().instanceBuilderSelectors()) {
                if (selector instanceof AsBoxed && ((AsBoxed<Selector<Context<?>>>) selector).boxed().test(context)) {
                    candidates.add(selector);
                }
            }
        }

        return candidates
                .stream()
                .max(Comparator.comparing(Selector::metrics))
                .map(s -> {
                    Function<Context<T>, T> function = this.generatedEngine.getCore().instanceBuilder(s);

                    return (Supplier<T>) () -> (T) function.apply(context);
                })
                .orElse(new DefaultInstanceBuilder(context.clazz()));
    }
}
