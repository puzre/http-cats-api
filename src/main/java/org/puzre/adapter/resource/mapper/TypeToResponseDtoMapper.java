package org.puzre.adapter.resource.mapper;

import jakarta.inject.Singleton;
import org.puzre.adapter.resource.dto.response.TypeResponseDto;
import org.puzre.adapter.resource.mapper.spi.IDomainToResponseMapper;
import org.puzre.core.domain.Type;

@Singleton
public class TypeToResponseDtoMapper implements IDomainToResponseMapper<Type, TypeResponseDto> {
    @Override
    public TypeResponseDto toResponseDto(Type domain) {
        return TypeResponseDto.builder()
                .id(domain.getId())
                .message(domain.getName())
                .build();
    }
}
