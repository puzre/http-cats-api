package org.puzre.adapter.resource.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class CatResponseDto {

    private int id;
    private String code;
    private String imagePath;
    private String message;

}
