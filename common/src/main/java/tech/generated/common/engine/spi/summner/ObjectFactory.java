package tech.generated.common.engine.spi.summner;

import tech.generated.common.Context;
import tech.generated.common.FillerFactory;
import tech.generated.common.Init;
import tech.generated.common.InstanceBuilderFactory;
import tech.generated.common.NewInstanceException;

import java.util.function.Function;
import java.util.function.Supplier;

public class ObjectFactory implements tech.generated.common.ObjectFactory {

    private final GeneratedEngine engine;

    public ObjectFactory(GeneratedEngine engine) {
        this.engine = engine;
    }

    @Override
    public <T> ObjectContext<T> buildContext(Init<T> init) throws NewInstanceException {
        final InstanceBuilderFactory instanceBuilderFactory = this.engine.instanceBuilderFactory();
        final ObjectContext<T> context = new ObjectContext<T>(init.clazz(), init.getBindings());
        final Supplier<T> instanceBuilder = instanceBuilderFactory.builder(context);
        final FillerFactory fillerFactory = this.engine.fillerFactory();
        final T object = instanceBuilder.get();
        final Function<T, T> filler = fillerFactory.filler(context);

        context.set(object);
        filler.apply(object);

        return context;
    }
}
