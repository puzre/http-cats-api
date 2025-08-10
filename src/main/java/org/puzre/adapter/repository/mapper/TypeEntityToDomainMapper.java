package org.puzre.adapter.repository.mapper;

import jakarta.inject.Singleton;
import org.puzre.adapter.repository.entity.TypeEntity;
import org.puzre.core.domain.Type;
import org.puzre.core.port.mapper.repository.IEntityToDomainMapper;

@Singleton
public class TypeEntityToDomainMapper implements IEntityToDomainMapper<TypeEntity, Type> {
    @Override
    public Type toDomain(TypeEntity entity) {
        return Type.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
