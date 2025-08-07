package org.puzre.core.port.mapper.repository;

public interface IDomainToResponseMapper<D, R> {
    R toResponseDto(D domain);
}
