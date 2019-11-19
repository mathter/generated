package tech.generated.common.engine.spi.summner;

public class GeneratedEngineFactory extends tech.generated.common.GeneratedEngineFactory {

    public static final String NAME = "winter";

    @Override
    protected tech.generated.common.GeneratedEngine newEngine(Object... params) {
        return new GeneratedEngine(params);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
