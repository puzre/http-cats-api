package org.puzre.core.exception;

import lombok.Getter;
import org.puzre.core.domain.ExceptionInformation;

public class TypeNotFoundException extends RuntimeException {

    @Getter
    private final ExceptionInformation exceptionInformation;

    public TypeNotFoundException(String message) {
        this.exceptionInformation = new ExceptionInformation(message);
    }
    
}
