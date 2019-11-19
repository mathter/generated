package tech.generated.common.engine.spi.summner;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class NameGenerator {
    private static final String NAME = "predefined.name.";

    private static final tech.generated.common.engine.spi.summner.NameGenerator SINGLITON = new tech.generated.common.engine.spi.summner.NameGenerator();

    private long index = 0L;

    private final String[] predefinedNames;

    private final Random nameIndexSelector;

    private final Lock lock = new ReentrantLock();

    private NameGenerator() {
        this.predefinedNames = tech.generated.common.engine.spi.summner.NameGenerator.predefinedNames();
        this.nameIndexSelector = new Random();
    }

    public static final String nextName() {
        return SINGLITON.next();
    }

    private String next() {
        this.lock.lock();

        try {
            return this.predefinedNames[this.nameIndexSelector.nextInt(this.predefinedNames.length)] + (this.index++);
        } finally {
            this.lock.unlock();
        }
    }

    private static String[] predefinedNames() {
        String value;
        final ResourceBundle bundle = ResourceBundle.getBundle("tech.generated.common.engine.spi.summner.messages");
        final List<String> result = new ArrayList<>();

        for (int i = 0; true; i++) {
            try {
                value = bundle.getString(NAME + i);
                result.add(value);
            } catch (MissingResourceException e) {
                break;
            }
        }

        return result.toArray(new String[result.size()]);
    }
}
