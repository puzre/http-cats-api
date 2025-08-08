package org.puzre.adapter.resource.mapper;

import jakarta.inject.Singleton;
import org.puzre.adapter.resource.dto.response.CatResponseDto;
import org.puzre.adapter.resource.dto.response.PageResponseDto;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;
import org.puzre.core.port.mapper.adapter.IDomainToResponseMapper;

@Singleton
public class PageToResponseDtoMapper implements IDomainToResponseMapper<Page<Cat>, PageResponseDto<CatResponseDto>> {

    private final IDomainToResponseMapper<Cat, CatResponseDto> iCatToResponseDtoMapper;

    public PageToResponseDtoMapper(
            IDomainToResponseMapper<Cat, CatResponseDto> iCatToResponseDtoMapper
    ) {
        this.iCatToResponseDtoMapper = iCatToResponseDtoMapper;
    }

    @Override
    public PageResponseDto<CatResponseDto> toResponseDto(Page<Cat> domain) {
       return new PageResponseDto<>(
                domain.getPage(),
                domain.getTotalPages(),
                domain.getData()
                        .stream()
                        .map(iCatToResponseDtoMapper::toResponseDto)
                        .toList()
        );
    }
}
