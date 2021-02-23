package tech.generated.configuration.dsl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public class DefaultConfiguration extends AbstractConfiguration {
    {
        this.add(this.nonstrict((c) -> RandomUtils.nextBoolean(), boolean.class));
        this.add(this.nonstrict((c) -> RandomUtils.nextBytes(1)[0], byte.class));
        this.add(this.nonstrict((c) -> (short) RandomUtils.nextInt(), short.class));
        this.add(this.nonstrict((c) -> RandomUtils.nextInt(), int.class));
        this.add(this.nonstrict((c) -> RandomUtils.nextLong(), long.class));
        this.add(this.nonstrict((c) -> RandomUtils.nextFloat(), float.class));
        this.add(this.nonstrict((c) -> RandomUtils.nextDouble(), double.class));
        this.add(this.nonstrict((c) -> RandomStringUtils.randomAlphanumeric(10), String.class));
        this.add(this.nonstrict((c) -> UUID.randomUUID(), UUID.class));
        this.add(this.nonstrict((c) -> new Date(), Date.class));
    }

    public DefaultConfiguration(Dsl dsl) {
        super(dsl);
    }
}
