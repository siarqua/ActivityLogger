package org.some.pkg.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Created by siarqua on 10.08.15.
 */
@ResponseStatus(value = NOT_FOUND, reason = "Entity not found")
public class EntityNotFoundException extends PersistanceException {
    public EntityNotFoundException() {}
    public EntityNotFoundException(Exception e) {}
}
