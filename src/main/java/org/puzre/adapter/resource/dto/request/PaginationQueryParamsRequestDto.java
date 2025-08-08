package org.puzre.adapter.resource.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.QueryParam;
import lombok.Getter;

@Getter
public class PaginationQueryParamsRequestDto {

    @QueryParam("page")
    @NotNull(message = "page is required")
    @Min(value = 1, message = "page must be greater than 0")
    private Integer page;

    @QueryParam("totalItems")
    @NotNull(message = "totalItems is required")
    @Min(value = 1, message = "totaItems must be greater than 0")
    private Integer totalItems;

}
