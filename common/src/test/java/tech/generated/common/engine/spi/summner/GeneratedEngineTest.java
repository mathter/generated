/*
 * Generated - testing becomes easier
 *
 * Copyright (C) 2020 mathter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.generated.common.engine.spi.summner;

import org.junit.Assert;
import org.junit.Test;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.GeneratedEngineFactory;
import tech.generated.common.Init;
import tech.generated.common.NewInstanceException;
import tech.generated.common.ObjectFactory;
import tech.generated.common.annotation.DefaultConfiguration;
import tech.generated.common.annotation.Filler;
import tech.generated.common.annotation.InstanceBuilder;

import java.util.UUID;

public class GeneratedEngineTest {

    @Test
    public void testSummer() {

        GeneratedEngine engine = GeneratedEngineFactory.newInstance(null);
        Assert.assertNotNull(engine);
        Assert.assertTrue(engine instanceof tech.generated.common.engine.spi.summner.GeneratedEngine);

        engine = GeneratedEngineFactory.newInstance(tech.generated.common.engine.spi.summner.GeneratedEngineFactory.NAME);
        Assert.assertNotNull(engine);
        Assert.assertTrue(engine instanceof tech.generated.common.engine.spi.summner.GeneratedEngine);

    }

    @Test
    public void testArray() {
        GeneratedEngine engine = GeneratedEngineFactory.newInstance(null,
                new DefaultConfiguration() {
                    @InstanceBuilder
                    public int[] ib() {
                        return new int[10];
                    }

                    @Filler
                    public int[] f(int[] a) {
                        a[0] = 1;

                        return a;
                    }
                });

        tech.generated.common.ObjectFactory objectFactory = engine.objectFactory();
        Assert.assertNotNull(objectFactory);

        int[] object = objectFactory.build(Init.builder(int[].class).build());
        Assert.assertNotNull(object);
    }

    @Test
    public void testFillObject() throws NewInstanceException {

        GeneratedEngine engine = GeneratedEngineFactory.newInstance(tech.generated.common.engine.spi.summner.GeneratedEngineFactory.NAME);
        ObjectFactory objectFactory = engine.objectFactory();
        Assert.assertNotNull(objectFactory);

        A object = objectFactory.build(Init.builder(A.class).build());
        Assert.assertNotNull(object);

        ObjectContext<A> ctx = objectFactory.buildContext(Init.builder(A.class).build());
        Assert.assertNotNull(ctx);
        Assert.assertEquals(4, ctx.child().count());
        Assert.assertEquals("intField", ctx.child().findFirst().get().name());
        Assert.assertEquals("string", ctx.child().skip(1).findFirst().get().name());
        Assert.assertEquals("uuid", ctx.child().skip(2).findFirst().get().name());

        Assert.assertNotEquals(0, ctx.get().intField);
        Assert.assertNotNull(ctx.get().string);
        Assert.assertNotNull(ctx.get().uuid);
    }

    private static class A {
        int intField;

        String string;

        UUID uuid;

        B b;

        public A() {
        }
    }

    private static class B {
        String name;
    }
}
