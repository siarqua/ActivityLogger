package org.some.pkg.service.rest;

import org.some.pkg.dao.ActivityDAO;
import org.some.pkg.entity.Activity;
import org.some.pkg.exceptions.EntityAlreadyExistsException;
import org.some.pkg.exceptions.EntityNotFoundException;
import org.some.pkg.exceptions.InternalPersistencyException;
import org.some.pkg.exceptions.PersistanceException;
import org.some.pkg.service.interfaces.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siarqua on 10.08.15.
 */
@Service
@Transactional
public class ActivityServiceRest implements ActivityService {

    @Autowired
    ActivityDAO activityDAO;

    public Activity add(Activity activity) throws PersistanceException {
        throwExceptionIfAlreadyExists(activity);
        Activity savedActivity = activityDAO.save(activity);
        System.out.println("savedActivity!!!!!!!!!!!!!!!!!! = " + savedActivity);
        return  savedActivity;
    }

    public Activity get(long id) throws PersistanceException {
        throwExceptionIfDoesentExists(id);
        Activity activity;
        try {
            activity = activityDAO.findById(id);
        } catch (Exception e) {
            throw new InternalPersistencyException(e);
        }
        return activity;
    }

    public Iterable<Activity> get() {
        return activityDAO.findAll();
    }

    private void throwExceptionIfDoesentExists(long id) throws PersistanceException {
        if(!activityDAO.exists(id)){
            throw new EntityNotFoundException();
        }

    }

    private void throwExceptionIfAlreadyExists(Activity activity) {
        if(activity.getId() != null && activityDAO.exists(activity.getId())){
            throw new EntityAlreadyExistsException();
        }
    }
}
