package org.puzre.core.port.mapper.adapter;

public interface IRequestToDomainMapper<R, D> {
    D toDomain(R requestDto);
}
