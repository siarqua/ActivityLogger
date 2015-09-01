package org.some.pkg.generator.datagenerators;

import org.some.pkg.entity.ActivityType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static org.some.pkg.entity.ActivityType.*;
/**
 * Created by siarqua on 24.07.15.
 */
public class ActivityTypeGenerator {
    private final Random random;
    private final List<ActivityType> activityTypes;

    public ActivityTypeGenerator() {
        random = new Random();
        activityTypes = Arrays.asList(LOGING, CYCLING, GYM, SPINNING);
    }

    public ActivityType generateActivity(){
        int bound = activityTypes.size();
        int index = random.nextInt(bound);
        return activityTypes.get(index);
    }
}
