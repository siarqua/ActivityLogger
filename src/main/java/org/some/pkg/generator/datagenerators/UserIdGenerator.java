package org.some.pkg.generator.datagenerators;

import java.util.Random;

/**
 * Created by siarqua on 24.07.15.
 */
public class UserIdGenerator {

    private final int bound;
    private final Random random;

    public UserIdGenerator(int bound) {
        this.bound = bound;
        random = new Random();
    }

    public long generate() {
        return Long.valueOf(random.nextInt(bound) + 1);
    }
}
