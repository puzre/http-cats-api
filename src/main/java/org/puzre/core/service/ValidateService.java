package org.puzre.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.core.exception.InvalidNumberException;
import org.puzre.core.exception.InvalidStringException;
import org.puzre.core.port.service.IValidateService;

@ApplicationScoped
public class ValidateService implements IValidateService {

    @Override
    public void validateNumber(int number, String message) throws InvalidNumberException {
        if (number <= 0)
            throw new InvalidNumberException(message);
    }

    @Override
    public void validateString(String string, String message) throws InvalidStringException {
        if (string == null || string.isBlank())
            throw new InvalidStringException(message);
    }

}
