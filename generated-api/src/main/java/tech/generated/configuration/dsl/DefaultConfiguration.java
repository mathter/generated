package tech.generated.configuration.dsl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public class DefaultConfiguration extends AbstractConfiguration {
    {
        nonstrict((c) -> RandomUtils.nextBoolean(), boolean.class);
        nonstrict((c) -> RandomUtils.nextBytes(1)[0], byte.class);
        nonstrict((c) -> (short) RandomUtils.nextInt(), short.class);
        nonstrict((c) -> RandomUtils.nextInt(), int.class);
        nonstrict((c) -> RandomUtils.nextLong(), long.class);
        nonstrict((c) -> RandomUtils.nextFloat(), float.class);
        nonstrict((c) -> RandomUtils.nextDouble(), double.class);
        nonstrict((c) -> RandomStringUtils.randomAlphanumeric(10), String.class);
        nonstrict((c) -> UUID.randomUUID(), UUID.class);
        nonstrict((c) -> new Date(), Date.class);
    }

    public DefaultConfiguration(Dsl dsl) {
        super(dsl);
    }
}
