package org.puzre.core.port.mapper.adapter;

public interface IDomainToResponseMapper<D, R> {
    R toResponseDto(D domain);
}
