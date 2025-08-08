package org.puzre.core.port.mapper;

import org.puzre.core.port.mapper.adapter.IDomainToResponseMapper;
import org.puzre.core.port.mapper.adapter.IRequestToDomainMapper;

public interface IAdapterMapper<D, RQ, RP> extends IRequestToDomainMapper<RQ, D>, IDomainToResponseMapper<D, RP> {
}
