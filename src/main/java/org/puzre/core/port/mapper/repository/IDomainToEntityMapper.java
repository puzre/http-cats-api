package org.puzre.core.port.mapper.repository;

public interface IDomainToEntityMapper <D, E> {
    E toEntity(D domain);
}
