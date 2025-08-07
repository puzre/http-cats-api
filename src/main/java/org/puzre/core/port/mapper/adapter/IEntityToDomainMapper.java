package org.puzre.core.port.mapper.adapter;

public interface IEntityToDomainMapper <E, D> {
    D toDomain(E entity);
}
