package org.puzre.core.port.mapper.adapter;

public interface IDomainToEntityMapper <D, E> {
    E toEntity(D domain);
}
