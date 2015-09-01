package org.some.pkg.service.rest;

import org.some.pkg.dao.DetailDAO;
import org.some.pkg.entity.Detail;
import org.some.pkg.exceptions.EntityAlreadyExistsException;
import org.some.pkg.exceptions.EntityNotFoundException;
import org.some.pkg.exceptions.InternalPersistencyException;
import org.some.pkg.exceptions.PersistanceException;
import org.some.pkg.service.interfaces.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by siarqua on 10.08.15.
 */
@Service
@Transactional
public class DetailServiceRest implements DetailService {

    @Autowired
    private DetailDAO detailDAO;

    public void add(Detail detail) throws PersistanceException {
        throwExceptionIfAlreadyExists(detail);
        detailDAO.save(detail);
    }

    public Detail get(long id) throws PersistanceException {
        throwExceptionIfDoesentExists(id);
        Detail detail;
        try {
            detail = detailDAO.findById(id);
        } catch (Exception e) {
            throw new InternalPersistencyException(e);
        }
        return detail;
    }

    private void throwExceptionIfDoesentExists(long id) throws PersistanceException {
        if(!detailDAO.exists(id)){
            throw new EntityNotFoundException();
        }

    }

    private void throwExceptionIfAlreadyExists(Detail detail) {
        if(detail.getId() != null && detailDAO.exists(detail.getId())){
            throw new EntityAlreadyExistsException();
        }
    }


}
