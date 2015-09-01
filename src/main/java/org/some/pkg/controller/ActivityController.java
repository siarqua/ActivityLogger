package org.some.pkg.controller;

import org.some.pkg.entity.Activity;
import org.some.pkg.entity.ActivityType;
import org.some.pkg.entity.Detail;
import org.some.pkg.service.interfaces.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by siarqua on 10.08.15.
 */
@RestController // same as @Controller CHECK
@RequestMapping(value = "/activities/api") // maps all method with prefix
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @ResponseBody
    @RequestMapping(consumes = APPLICATION_JSON_VALUE,method = POST)
    public ResponseEntity<Long> add(@RequestBody Activity activity){
        Activity addedActivity = activityService.add(activity);
        System.out.println("addedActivity@@@@@@@@@@ = " + addedActivity);
        return ResponseEntity.ok().body(addedActivity.getId());
    }

    @ResponseBody
    @RequestMapping(method = GET, value = "/{id}")
    public ResponseEntity<Activity> get(@PathVariable long id){
        Activity detail = activityService.get(id);
        return ResponseEntity.ok().body(detail);
    }

    @ResponseBody
    @RequestMapping(method = GET)
    public ResponseEntity<Iterable<Activity>> get(){
        Iterable<Activity> activity = activityService.get();
        return ResponseEntity.ok().body(activity);
    }

    @ResponseBody
    @RequestMapping(method = GET, produces = TEXT_PLAIN_VALUE, value = "/add-automatic")
    public String addAutomaticAlbum() {

        Detail detail1 = new Detail();
        detail1.setDescription("Desc1");
        detail1.setStartTime(new Date());

        Detail detail2 = new Detail();
        detail2.setDescription("Desc1");
        detail2.setStartTime(new Date());

        Activity activity = new Activity();
        activity.setUserId(1L);
        activity.setType(ActivityType.GYM);

        activity.setDetails(Arrays.asList(detail1, detail2));
        detail1.setActivity(activity);
        detail2.setActivity(activity);

        activityService.add(activity);
        return "[addAutomaticAlbum] added: " + activity.toString();

    }

}
