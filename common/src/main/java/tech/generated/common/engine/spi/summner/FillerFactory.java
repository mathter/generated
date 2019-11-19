package tech.generated.common.engine.spi.summner;

import tech.generated.common.Context;

import java.util.function.Function;

class FillerFactory implements tech.generated.common.FillerFactory {
    private final GeneratedEngine generatedEngine;

    FillerFactory(GeneratedEngine generatedEngine) {
        this.generatedEngine = generatedEngine;
    }

    @Override
    public <T> Function<T, T> filler(Context<T> context) {
        return new DefaultFiller(this.generatedEngine, (ValueContext) context);
    }
}