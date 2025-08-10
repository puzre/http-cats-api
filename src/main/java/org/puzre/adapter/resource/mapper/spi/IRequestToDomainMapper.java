package org.puzre.adapter.resource.mapper.spi;

public interface IRequestToDomainMapper<R, D> {
    D toDomain(R requestDto);
}
