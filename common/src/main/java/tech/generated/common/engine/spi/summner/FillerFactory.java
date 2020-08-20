package tech.generated.common.engine.spi.summner;

import tech.generated.common.Context;
import tech.generated.common.engine.spi.summner.path.AsBoxed;
import tech.generated.common.path.Selector;
import tech.generated.common.util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

class FillerFactory implements tech.generated.common.FillerFactory {
    private final GeneratedEngine generatedEngine;

    FillerFactory(GeneratedEngine generatedEngine) {
        this.generatedEngine = generatedEngine;
    }

    @Override
    public <T> Function<T, T> filler(final Context<T> context) {
        final Collection<Selector<Context<?>>> candidates = new ArrayList<>();

        for (Selector<Context<?>> selector : this.generatedEngine.getCore().filterSelectors()) {
            if (selector.test(context)) {
                candidates.add(selector);
            }
        }

        if (Util.isBoxing(context.clazz()) && candidates.isEmpty()) {
            for (Selector<Context<?>> selector : this.generatedEngine.getCore().filterSelectors()) {
                if (selector instanceof AsBoxed && ((AsBoxed<Selector<Context<?>>>) selector).boxed().test(context)) {
                    candidates.add(selector);
                }
            }
        }

        return candidates
                .stream()
                .max(Comparator.comparing(Selector::metrics))
                .map(s -> {
                    BiFunction<Context<T>, T, T> f = this.generatedEngine.getCore().filler(s);

                    Function<T, T> function = (T o) -> f.apply(context, o);

                    return function;
                })
                .orElse(new DefaultFiller<T>((ValueContext<T>) context));

    }
}