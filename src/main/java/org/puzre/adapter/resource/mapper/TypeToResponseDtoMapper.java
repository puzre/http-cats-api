package org.puzre.adapter.resource.mapper;

import jakarta.inject.Singleton;
import org.puzre.adapter.resource.dto.response.TypeResponseDto;
import org.puzre.core.domain.Type;
import org.puzre.core.port.mapper.adapter.IDomainToResponseMapper;

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
