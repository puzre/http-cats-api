package org.puzre.core.exception;

import lombok.Getter;
import org.puzre.core.domain.ExceptionInformation;

public class CatNotFoundException extends RuntimeException {

    @Getter
    private final ExceptionInformation exceptionInformation;

    public CatNotFoundException(String message) {
        this.exceptionInformation = new ExceptionInformation(message);
    }

}
