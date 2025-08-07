package org.puzre.core.port.mapper.repository;

public interface IRequestToDomainMapper<R, D> {
    D toDomain(R requestDto);
}
