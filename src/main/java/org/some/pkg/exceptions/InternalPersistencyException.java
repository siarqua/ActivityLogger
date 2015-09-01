package org.some.pkg.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Created by siarqua on 10.08.15.
 */
@ResponseStatus(value = INTERNAL_SERVER_ERROR, reason = "Server encountered internal persistence error, operation could not be permitted.")
public class InternalPersistencyException extends PersistanceException {

    public InternalPersistencyException() {
    }

    public InternalPersistencyException(Exception e) {
        super(e);
    }
}
