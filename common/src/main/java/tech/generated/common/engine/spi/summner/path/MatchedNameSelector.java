package tech.generated.common.engine.spi.summner.path;


import tech.generated.common.Context;
import tech.generated.common.path.Path;
import tech.generated.common.path.Selector;

import java.util.function.BiPredicate;
import java.util.regex.Pattern;

public class MatchedNameSelector extends CommonValueMatchSelector<String> {

    public MatchedNameSelector(String name, Selector<Context<?>> parent, long metrics, final String value) {
        super(name, parent, metrics, new BiPredicate<String, Path<?, ?>>() {
            private final Pattern pattern = Pattern.compile(value.replace("*", ".*"));

            @Override
            public boolean test(String name, Path<?, ?> path) {
                return this.pattern.matcher(name).matches();
            }
        }, value);
    }
}
