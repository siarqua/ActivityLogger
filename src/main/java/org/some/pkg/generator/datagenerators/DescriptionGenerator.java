package org.some.pkg.generator.datagenerators;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * Created by siarqua on 24.07.15.
 */
public class DescriptionGenerator {
    public static List<String> DESCRIPTIONS;
    private final Random random;

    public DescriptionGenerator() {
        DESCRIPTIONS = Arrays.asList(Descriptions.I_WAS_DOING1, Descriptions.I_WAS_DOING2, Descriptions.I_WAS_DOING3, Descriptions.NEXT_WEEK, Descriptions.NICE_TRAINING);
        random = new Random();
    }

    public String generate(int value) {
        return String.format(Descriptions.BURNED,value);
    }

    public String generate() {
        int descriptionNumber = random.nextInt(DESCRIPTIONS.size());
        return DESCRIPTIONS.get(descriptionNumber);
    }
}
