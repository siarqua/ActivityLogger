package org.some.pkg.service.interfaces;

import org.some.pkg.entity.Activity;

import java.util.List;

/**
 * Created by siarqua on 10.08.15.
 */
public interface ActivityService {
    Activity add(Activity activity);
    Activity get(long id);

    Iterable<Activity> get();
}
