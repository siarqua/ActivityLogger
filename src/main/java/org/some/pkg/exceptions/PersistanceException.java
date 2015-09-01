package org.some.pkg.exceptions;

/**
 * Created by siarqua on 10.08.15.
 */
public class PersistanceException extends RuntimeException {

    public PersistanceException() {
    }

    public PersistanceException(Exception e) {
     super(e);
    }
}
