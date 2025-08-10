package org.puzre.adapter.resource.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.QueryParam;
import lombok.Getter;

@Getter
public class CatMessageRequestDto {

    @QueryParam("message")
    @NotNull(message = "message is required")
    @NotEmpty(message = "message must not be empty")
    private String message;

}
