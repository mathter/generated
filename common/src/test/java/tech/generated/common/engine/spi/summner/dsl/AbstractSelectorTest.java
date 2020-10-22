package tech.generated.common.engine.spi.summner.dsl;

import org.junit.Test;
import tech.generated.common.dsl.Selector;

public class AbstractSelectorTest {

    @Test(expected = IllegalStateException.class)
    public void testCheckClassSelector() {
        Selector selector = new NonStrict(String.class, null);
        selector.path("name").strict(Integer.class);
    }
}