package org.some.pkg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by siarqua on 10.08.15.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Entity already exists")
public class EntityAlreadyExistsException extends PersistanceException {

    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(Exception e){
        super(e);
    }
}
