package org.puzre.adapter.resource.mapper.spi;

public interface IDomainToResponseMapper<D, R> {
    R toResponseDto(D domain);
}
