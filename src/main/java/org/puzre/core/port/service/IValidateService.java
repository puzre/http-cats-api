package org.puzre.core.port.service;

import org.puzre.core.exception.InvalidNumberException;

public interface IValidateService {

    void validatePaginatedNumber(int number, String message) throws InvalidNumberException;

}
