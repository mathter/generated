package tech.generated.common.path;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

public class PathTest {

    @Test
    public void testStream() {

        final PathImpl p0 = new PathImpl(null);
        final PathImpl p1 = new PathImpl(p0);
        final PathImpl p2 = new PathImpl(p1);
        final PathImpl p3 = new PathImpl(p2);

        Assert.assertEquals(1, p0.stream().count());
        Assert.assertEquals(2, p1.stream().count());
        Assert.assertEquals(3, p2.stream().count());
        Assert.assertEquals(4, p3.stream().count());
    }

    private static class PathImpl implements Path<String, PathImpl> {

        private String node = RandomStringUtils.random(10);

        private String name = RandomStringUtils.random(5);

        private Path<String, PathImpl> parent;

        public PathImpl(Path<String, PathImpl> parent) {
            this.parent = parent;
        }

        @Override
        public Class<String> clazz() {
            return String.class;
        }

        @Override
        public String node() {
            return this.node;
        }

        @Override
        public String name() {
            return this.name;
        }

        @Override
        public Path<?, ? extends PathImpl> parent() {
            return this.parent;
        }

        @Override
        public Stream<Path<?, ?>> child() {
            return null;
        }
    }
}
