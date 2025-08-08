package org.puzre.core.port.mapper;

import org.puzre.core.port.mapper.repository.IDomainToEntityMapper;
import org.puzre.core.port.mapper.repository.IEntityToDomainMapper;

public interface IRepositoryAdapter<D, E> extends IDomainToEntityMapper<D, E>, IEntityToDomainMapper<E, D> {
}
