package org.some.pkg.generator;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.some.pkg.entity.Activity;
import org.some.pkg.entity.ActivityType;
import org.some.pkg.entity.Detail;
import org.some.pkg.generator.datagenerators.ActivityTypeGenerator;
import org.some.pkg.generator.datagenerators.DescriptionGenerator;
import org.some.pkg.generator.datagenerators.TimeGenerator;
import org.some.pkg.generator.datagenerators.UserIdGenerator;
import org.some.pkg.service.restclient.ActivityClient;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by siarqua on 11.08.15.
 */
public class ActivityGenerator {
    static ActivityClient client;

    public ActivityGenerator() {
        this.client = new ActivityClient();
    }

    public void generate() {
    }

    public static Activity get(Long id) {
        return client.get(id);
    }

    public static void main(String[] args) {
        client = new ActivityClient();
        generateActivities(500, 10);
    }

    private static void generateActivities(int numberOfActivities, int numberOfDetails) {
        UserIdGenerator userIdGenerator = new UserIdGenerator(10);
        ActivityTypeGenerator activityTypeGenerator = new ActivityTypeGenerator();
        for (int i = 0; i < numberOfActivities; i++) {
            Activity activity = new Activity();
            activity.setId(1L);
            activity.setUserId(userIdGenerator.generate());
            activity.setType(activityTypeGenerator.generateActivity());
            List<Detail> details = prepareDetails(activity, numberOfDetails);
            activity.setDetails(details);
            client.post(activity);
        }
    }

    private static List<Detail> prepareDetails(Activity activity, int numberOfDetails) {
        List<Detail> details = Lists.newArrayList();
        TimeGenerator timeGenerator = new TimeGenerator();
        DescriptionGenerator descriptionGenerator = new DescriptionGenerator();
        for (int j = 0; j < numberOfDetails; j++) {
            DateTime startTime = timeGenerator.generate();
            Detail detail = new Detail();
            detail.setId(Long.valueOf(j) + activity.getId());
            detail.setStartTime(startTime.toDate());
            detail.setEndTime(timeGenerator.generateAfter(startTime).toDate());
            detail.setDescription(descriptionGenerator.generate());
            detail.setActivity(activity);
            details.add(detail);
        }
        return details;
    }
}
