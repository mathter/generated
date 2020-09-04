package tech.generated.common.engine.spi.summner.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;

public abstract class SelectorAnnotationProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(SelectorAnnotationProcessor.class);

    private static final Map<Class<? extends Annotation>, Optional<SelectorAnnotationProcessor>> ANNOTATION_PROCESSOR_MAP = new HashMap<>();

    static {
        ServiceLoader<SelectorAnnotationProcessor> serviceLoader = ServiceLoader.load(SelectorAnnotationProcessor.class);

        for (SelectorAnnotationProcessor processor : serviceLoader) {
            ANNOTATION_PROCESSOR_MAP.put(processor.annotationClass(), Optional.of(processor));
            LOG.info("Annotation processor '{}' for class '{}' loaded!", processor, processor.annotationClass());
        }
    }

    public static Optional<SelectorAnnotationProcessor> get(Annotation annotation) {
        final Class<? extends Annotation> clazz = annotation.annotationType();
        Optional<SelectorAnnotationProcessor> annotationProcessor;

        if ((annotationProcessor = ANNOTATION_PROCESSOR_MAP.get(clazz)) == null) {
            LOG.warn("There is no annotation processor for '" + clazz + "!");
            annotationProcessor = Optional.empty();
        }

        return annotationProcessor;
    }

    public abstract long metrics();

    public abstract Object process(AnnotationBasedConfigurationFactory factory, Object configuration, Method method, Annotation annotation);

    public abstract Class<? extends Annotation> annotationClass();
}
