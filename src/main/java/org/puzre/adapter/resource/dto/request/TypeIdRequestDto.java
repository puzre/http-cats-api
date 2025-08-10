package org.puzre.adapter.resource.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.PathParam;
import lombok.Getter;

@Getter
public class TypeIdRequestDto {

    @PathParam("typeId")
    @Min(value = 1, message = "typeId must be greater than zero")
    @NotNull(message = "typeId is required")
    private Long typeId;

}
