package org.puzre.adapter.resource.mapper;

import jakarta.inject.Singleton;
import org.puzre.adapter.resource.dto.response.CatResponseDto;
import org.puzre.adapter.resource.mapper.spi.IDomainToResponseMapper;
import org.puzre.core.domain.Cat;

@Singleton
public class CatToResponseDtoMapper implements IDomainToResponseMapper<Cat, CatResponseDto> {
    @Override
    public CatResponseDto toResponseDto(Cat domain) {
        return CatResponseDto.builder()
                .id(domain.getId())
                .code(domain.getCode())
                .imagePath(domain.getImagePath())
                .message(domain.getMessage())
                .build();
    }
}
