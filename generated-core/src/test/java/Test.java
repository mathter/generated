import tech.generated.ObjectFactory;
import tech.generated.ObjectFactoryProducer;
import tech.generated.Spec;

import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
//        ObjectFactoryProducer producer = ObjectFactoryProducer.producer();
//        ObjectFactory factory = producer.factory(null);
//
//        System.out.println(factory.build(Spec.of(Integer.class)));
//
//        System.out.println(producer);

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).skip(10).forEach(e -> System.out.println(e));
    }
}