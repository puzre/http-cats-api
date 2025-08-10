package org.puzre.adapter.resource.dto.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class PageResponseDto<T> {

    private int page;
    private int pageCount;
    private List<T> data;

}
