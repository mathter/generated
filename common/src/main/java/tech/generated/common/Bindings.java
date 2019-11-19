package tech.generated.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Bindings for Generated Engine.
 *
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Bindings {

    public <T> T get(Object key);

    public <T> void put(Object key, T value);

    public void remove(Object key);

    public static Bindings bindings(Bindings parent, Object... args) {
        final Simple result = new Simple(parent);

        if (args != null && args.length > 0) {
            if (args.length % 2 == 0) {
                for (int i = 0; i < args.length; i += 2) {
                    Object key = args[i];
                    Object value = args[i + 1];

                    result.put(key, value);
                }
            } else {
                throw new IllegalArgumentException("Even count of argument required! Now count of arguments is " + args.length);
            }
        }

        return result;
    }

    public static Bindings bindings(Object... args) {
        return Bindings.bindings(null, args);
    }

    static final class Simple implements Bindings {

        private final Bindings parent;

        private final Map<Object, Object> map;

        public Simple(Bindings parent) {
            this.map = new HashMap<>();
            this.parent = parent;
        }

        @Override
        public <T> T get(Object key) {
            T result;

            if ((result = (T) this.map.get(key)) == null) {
                if (this.parent != null) {
                    result = this.parent.get(key);
                }
            }

            return result;
        }

        @Override
        public <T> void put(Object key, T value) {
            this.map.put(key, value);
        }

        @Override
        public void remove(Object key) {
            if (this.map.containsKey(key)) {
                this.map.remove(key);
            } else {
                this.parent.remove(key);
            }
        }
    }
}
