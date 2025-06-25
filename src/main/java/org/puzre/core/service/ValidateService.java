package org.puzre.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.core.exception.InvalidNumberException;
import org.puzre.core.port.service.IValidateService;

@ApplicationScoped
public class ValidateService implements IValidateService {

    @Override
    public void validatePaginatedNumber(int number, String message) throws InvalidNumberException {
        if (number <= 0)
            throw new InvalidNumberException(message);
    }

}
