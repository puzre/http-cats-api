package org.puzre.core.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class Page <T> {

    private int page;
    private int pageCount;
    private List<T> data;

}
