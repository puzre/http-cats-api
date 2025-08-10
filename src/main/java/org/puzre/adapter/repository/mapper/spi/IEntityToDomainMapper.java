package org.puzre.adapter.repository.mapper.spi;

public interface IEntityToDomainMapper <E, D> {
    D toDomain(E entity);
}
