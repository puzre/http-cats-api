package org.puzre.adapter.repository.mapper;

import jakarta.inject.Singleton;
import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.repository.mapper.spi.IEntityToDomainMapper;
import org.puzre.core.domain.Cat;

@Singleton
public class CatEntityToDomainMapper implements IEntityToDomainMapper<CatEntity, Cat> {
    @Override
    public Cat toDomain(CatEntity entity) {
        return Cat.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .imagePath(entity.getImagePath())
                .message(entity.getMessage())
                .build();
    }
}
