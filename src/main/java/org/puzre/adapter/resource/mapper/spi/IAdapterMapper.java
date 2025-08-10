package org.puzre.adapter.resource.mapper.spi;

public interface IAdapterMapper<D, RQ, RP> extends IRequestToDomainMapper<RQ, D>, IDomainToResponseMapper<D, RP> {
}
