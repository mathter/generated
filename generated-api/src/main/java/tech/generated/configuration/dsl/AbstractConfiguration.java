package tech.generated.configuration.dsl;

import tech.generated.Context;
import tech.generated.Filler;
import tech.generated.InstanceBuilder;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AbstractConfiguration implements Configuration, Specification {

    private final Configuration configuration;

    public AbstractConfiguration() {
        this(DslFactory.dsl());
        this.reg(
                this
                        .custom((c) -> c.stream().count() > maxGenerationDeep().get())
                        .metrics((c) -> Long.MAX_VALUE)
                        .nonstrict((c, o) -> o, Object.class)
        );
    }

    public AbstractConfiguration(Dsl dsl) {
        this(dsl.configuration());
    }

    public AbstractConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Configuration reg(Selectable selectable) {
        return this.configuration.reg(selectable);
    }

    @Override
    public Collection<Selectable> selectables() {
        return this.configuration.selectables();
    }

    @Override
    public String name() {
        return this.configuration.name();
    }

    @Override
    public <T> Selectable nonstrict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.configuration.nonstrict(function, clazz);
    }

    @Override
    public <T> Selectable nonstrict(Filler<? extends T> function, Class<T> clazz) {
        return this.configuration.nonstrict(function, clazz);
    }

    @Override
    public <T> Selector nonstrict(Class<T> clazz) {
        return this.configuration.nonstrict(clazz);
    }

    @Override
    public Selector path(String path) {
        return this.configuration.path(path);
    }

    @Override
    public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.configuration.strict(function, clazz);
    }

    @Override
    public <T> Selector strict(Class<T> clazz) {
        return this.configuration.strict(clazz);
    }

    @Override
    public <T> Selectable strict(Filler<T> function, Class<T> clazz) {
        return this.strict(function, clazz);
    }

    @Override
    public Selector custom(Predicate<Context<?>> predicate) {
        return this.configuration.custom(predicate);
    }

    @Override
    public Supplier<Long> maxGenerationDeep() {
        return SpecificationAdapter.DEFAULT_MAX_GENERATION_DEEP;
    }
}
