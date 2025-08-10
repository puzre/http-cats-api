package org.puzre.adapter.repository.mapper.spi;

public interface IDomainToEntityMapper <D, E> {
    E toEntity(D domain);
}
