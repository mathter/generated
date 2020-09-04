package tech.generated.common.engine.spi.summner;

import tech.generated.common.annotation.DefaultConfiguration;
import tech.generated.common.engine.spi.summner.annotation.AnnotationBasedConfigurationFactory;

class GeneratedEngine implements tech.generated.common.GeneratedEngine {
    private final Configuration configuration;

    public GeneratedEngine(Object[] params) {
        if (params == null || params.length == 0) {
            this.configuration = new AnnotationBasedConfigurationFactory().build(new DefaultConfiguration());
        } else {
            this.configuration = new AnnotationBasedConfigurationFactory().build(params[0]);
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

    Configuration getCore() {
        return configuration;
    }
}
