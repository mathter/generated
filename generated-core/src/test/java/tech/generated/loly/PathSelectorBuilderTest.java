package tech.generated.loly;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.generated.configuration.dsl.Dsl;
import tech.generated.configuration.dsl.DslFactory;

public class PathSelectorBuilderTest {

    @Test
    public void test() {
        Dsl dsl = DslFactory.dsl();
        Selector selector = PathSelectorBuilder.build(
                dsl
                        .path("/a*/name/../..4/das")
                        .nonstrict((c) -> RandomStringUtils.randomAlphanumeric(10), String.class)
                        .selector()
                        .next(),
                null
        );

        Assertions.assertEquals(NameEqualsSelector.class, selector.getClass());
        Assertions.assertEquals(SkipSelector.class, selector.next().getClass());
        Assertions.assertEquals(NameEqualsSelector.class, selector.next().next().getClass());
        Assertions.assertEquals(NameEqualsSelector.class, selector.next().next().getClass());

    }
}
