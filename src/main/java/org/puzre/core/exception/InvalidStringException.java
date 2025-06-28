package org.puzre.core.exception;

import lombok.Getter;
import org.puzre.core.domain.ExceptionInformation;

public class InvalidStringException extends RuntimeException {

    @Getter
    private final ExceptionInformation exceptionInformation;

    public InvalidStringException(String message) {
        this.exceptionInformation = new ExceptionInformation(message);
    }

}
