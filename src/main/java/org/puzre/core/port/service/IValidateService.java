package org.puzre.core.port.service;

import org.puzre.core.exception.InvalidNumberException;
import org.puzre.core.exception.InvalidStringException;

public interface IValidateService {

    void validateNumber(int number, String message) throws InvalidNumberException;
    void validateString(String string, String message) throws InvalidStringException;

}
