package org.puzre.core.port.mapper.repository;

public interface IEntityToDomainMapper <E, D> {
    D toDomain(E entity);
}
