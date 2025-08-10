package org.puzre.adapter.repository.mapper.spi;

public interface IRepositoryAdapter<D, E> extends IDomainToEntityMapper<D, E>, IEntityToDomainMapper<E, D> {
}
