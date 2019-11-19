package tech.generated.common.annotation;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.UUID;

public class DefaultConfiguration {

    @ForClass(boolean.class)
    @InstanceBuilder
    public boolean booleanInstanceBuilder() {
        return RandomUtils.nextBoolean();
    }

    @ForClass(byte.class)
    @InstanceBuilder
    public byte byteInstanceBuilder() {
        return RandomUtils.nextBytes(1)[0];
    }

    @ForClass(short.class)
    @InstanceBuilder
    public short shortInstanceBuilder() {
        return (short) RandomUtils.nextInt();
    }

    @ForClass(int.class)
    @InstanceBuilder
    public int intInstanceBuilder() {
        return RandomUtils.nextInt();
    }

    @ForClass(long.class)
    @InstanceBuilder
    public long longInstanceBuilder() {
        return RandomUtils.nextLong();
    }

    @ForClass(float.class)
    @InstanceBuilder
    public float floatInstanceBuilder() {
        return RandomUtils.nextFloat();
    }

    @ForClass(double.class)
    @InstanceBuilder
    public double doubleInstanceBuilder() {
        return RandomUtils.nextDouble();
    }

    @ForClass(String.class)
    @InstanceBuilder
    public String stringInstanceBuilder() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    @ForClass(String.class)
    @InstanceBuilder
    @Path("name")
    public String stringInstanceBuilder1() {
        return "Name";
    }

    @ForClass(UUID.class)
    @InstanceBuilder
    public UUID uuidInstanceBuilder() {
        return UUID.randomUUID();
    }
}
