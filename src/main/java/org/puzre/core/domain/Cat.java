package org.puzre.core.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class Cat {

    private int id;
    private String code;
    private String imagePath;
    private String message;

}
