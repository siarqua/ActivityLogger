package org.some.pkg.service.interfaces;

import org.some.pkg.entity.Detail;
import org.some.pkg.exceptions.EntityNotFoundException;
import org.some.pkg.exceptions.PersistanceException;

/**
 * Created by siarqua on 10.08.15.
 */
public interface DetailService {
    void add(Detail detail) throws PersistanceException;
    Detail get(long id) throws EntityNotFoundException;
}
