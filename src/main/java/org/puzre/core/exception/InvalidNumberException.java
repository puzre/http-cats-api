package org.puzre.core.exception;

import lombok.Getter;
import org.puzre.core.domain.ExceptionInformation;

public class InvalidNumberException extends RuntimeException {

    @Getter
    private final ExceptionInformation exceptionInformation;

    public InvalidNumberException(String message) {
        this.exceptionInformation = new ExceptionInformation(message);
    }

}
