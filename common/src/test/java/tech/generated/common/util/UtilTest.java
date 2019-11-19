package tech.generated.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@linkplain Util} class.
 *
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public class UtilTest {

    @Test
    public void testIsPrimitive() {
        Assert.assertTrue("boolean.class is a primitive!", Util.isPrimitive(boolean.class));
        Assert.assertTrue("byte.class is a primitive!", Util.isPrimitive(byte.class));
        Assert.assertTrue("short.class is a primitive!", Util.isPrimitive(short.class));
        Assert.assertTrue("int.class is a primitive!", Util.isPrimitive(int.class));
        Assert.assertTrue("long.class is a primitive!", Util.isPrimitive(long.class));
        Assert.assertTrue("float.class is a primitive!", Util.isPrimitive(float.class));
        Assert.assertTrue("double.class is a primitive!", Util.isPrimitive(double.class));

        Assert.assertFalse("Boolean.class is not a primitive!", Util.isPrimitive(Boolean.class));
        Assert.assertFalse("Byte.class is not a primitive!", Util.isPrimitive(Byte.class));
        Assert.assertFalse("Short.class is not a primitive!", Util.isPrimitive(Short.class));
        Assert.assertFalse("Integer.class is not a primitive!", Util.isPrimitive(Integer.class));
        Assert.assertFalse("Long.class is not a primitive!", Util.isPrimitive(Long.class));
        Assert.assertFalse("Float.class is not a primitive!", Util.isPrimitive(Float.class));
        Assert.assertFalse("Double.class is not a primitive!", Util.isPrimitive(Double.class));

        Assert.assertFalse("Object.class is not a primitive!", Util.isPrimitive(Object.class));
    }

    @Test
    public void testIsBoxed() {
        Assert.assertFalse("boolean.class is not a boxed!", Util.isBoxing(boolean.class));
        Assert.assertFalse("byte.class is a not boxed!", Util.isBoxing(byte.class));
        Assert.assertFalse("short.class is not a boxed!", Util.isBoxing(short.class));
        Assert.assertFalse("int.class is a not boxed!", Util.isBoxing(int.class));
        Assert.assertFalse("long.class is a not boxed!", Util.isBoxing(long.class));
        Assert.assertFalse("float.class is a not boxed!", Util.isBoxing(float.class));
        Assert.assertFalse("double.class is a not boxed!", Util.isBoxing(double.class));

        Assert.assertTrue("Boolean.class is a boxed!", Util.isBoxing(Boolean.class));
        Assert.assertTrue("Byte.class is a boxed!", Util.isBoxing(Byte.class));
        Assert.assertTrue("Short.class is a boxed!", Util.isBoxing(Short.class));
        Assert.assertTrue("Integer.class is a boxed!", Util.isBoxing(Integer.class));
        Assert.assertTrue("Long.class is a boxed!", Util.isBoxing(Long.class));
        Assert.assertTrue("Float.class is a boxed!", Util.isBoxing(Float.class));
        Assert.assertTrue("Double.class is a boxed!", Util.isBoxing(Double.class));

        Assert.assertFalse("Object.class is not a boxed!", Util.isBoxing(Object.class));
    }

    @Test
    public void testDualBoolean() {
        Class<?> clazz = Util.getDual(boolean.class);
        Assert.assertEquals(Boolean.class, clazz);
    }

    @Test
    public void testDualBooleanBox() {
        Class<?> clazz = Util.getDual(Boolean.class);
        Assert.assertEquals(boolean.class, clazz);
    }

    @Test
    public void testDualByte() {
        Class<?> clazz = Util.getDual(byte.class);
        Assert.assertEquals(Byte.class, clazz);
    }

    @Test
    public void testDualByteBox() {
        Class<?> clazz = Util.getDual(Byte.class);
        Assert.assertEquals(byte.class, clazz);
    }

    @Test
    public void testDualShort() {
        Class<?> clazz = Util.getDual(short.class);
        Assert.assertEquals(Short.class, clazz);
    }

    @Test
    public void testDualShortBox() {
        Class<?> clazz = Util.getDual(Short.class);
        Assert.assertEquals(short.class, clazz);
    }

    @Test
    public void testDualInteger() {
        Class<?> clazz = Util.getDual(int.class);
        Assert.assertEquals(Integer.class, clazz);
    }

    @Test
    public void testDualIntegerBox() {
        Class<?> clazz = Util.getDual(Integer.class);
        Assert.assertEquals(int.class, clazz);
    }

    @Test
    public void testDualLong() {
        Class<?> clazz = Util.getDual(long.class);
        Assert.assertEquals(Long.class, clazz);
    }

    @Test
    public void testDualLongBox() {
        Class<?> clazz = Util.getDual(Long.class);
        Assert.assertEquals(long.class, clazz);
    }

    @Test
    public void testDualFloat() {
        Class<?> clazz = Util.getDual(float.class);
        Assert.assertEquals(Float.class, clazz);
    }

    @Test
    public void testDualFloatBox() {
        Class<?> clazz = Util.getDual(Float.class);
        Assert.assertEquals(float.class, clazz);
    }

    @Test
    public void testDualDouble() {
        Class<?> clazz = Util.getDual(double.class);
        Assert.assertEquals(Double.class, clazz);
    }

    @Test
    public void testDualDoubleBox() {
        Class<?> clazz = Util.getDual(Double.class);
        Assert.assertEquals(double.class, clazz);
    }

    @Test
    public void testGetFieldValue() throws NoSuchFieldException {
        A a = new A();
        a.a = new A();

        Util.getFieldValue(A.class.getDeclaredField("a"), a);
    }
}

class A {
    A a;
}
