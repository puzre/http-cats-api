package org.puzre.adapter.resource.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.PathParam;
import lombok.Getter;

@Getter
public class GetCatByIdPathParamRequestDto {

    @PathParam("catId")
    @NotNull(message = "catId is required")
    @Min(value = 1, message = "catId must be greater than zero")
    private Long catId;

}
