package org.puzre.core.port.mapper;

import org.puzre.core.port.mapper.adapter.IDomainToEntityMapper;
import org.puzre.core.port.mapper.adapter.IEntityToDomainMapper;

public interface IRepositoryAdapter<D, E> extends IDomainToEntityMapper<D, E>, IEntityToDomainMapper<E, D> {
}
