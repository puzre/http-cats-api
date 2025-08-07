package org.puzre.core.port.mapper;

import org.puzre.core.port.mapper.repository.IDomainToResponseMapper;
import org.puzre.core.port.mapper.repository.IRequestToDomainMapper;

public interface IAdapterMapper<D, RQ, RP> extends IRequestToDomainMapper<RQ, D>, IDomainToResponseMapper<D, RP> {
}
