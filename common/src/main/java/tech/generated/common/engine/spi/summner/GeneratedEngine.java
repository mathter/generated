package tech.generated.common.engine.spi.summner;

import tech.generated.common.annotation.DefaultConfiguration;
import tech.generated.common.engine.spi.summner.annotation.AnnotationBasedCoreBuilder;

class GeneratedEngine implements tech.generated.common.GeneratedEngine {
    private final Core core;

    public GeneratedEngine(Object[] params) {
        if (params == null || params.length == 0) {
            this.core = new AnnotationBasedCoreBuilder(this).build(new DefaultConfiguration());
        } else {
            this.core = new AnnotationBasedCoreBuilder(this).build(params[0]);
        }
    }

    @Override
    public tech.generated.common.ObjectFactory objectFactory() {
        return new ObjectFactory(this);
    }

    @Override
    public tech.generated.common.InstanceBuilderFactory instanceBuilderFactory() {
        return new InstanceBuilderFactory(this);
    }

    @Override
    public tech.generated.common.FillerFactory fillerFactory() {
        return new FillerFactory(this);
    }

    Core getCore() {
        return core;
    }
}
