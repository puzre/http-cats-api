package org.puzre.adapter.resource.dto.response;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import lombok.Data;

import java.util.List;

@Data
public class PaginatedResponse<E, D> {

    private List<D> data;
    private int page;
    private int totalPages;

    public PaginatedResponse(PanacheQuery<E> panacheQuery, List<D> data) {
        this.data = data;
        this.page = panacheQuery.page().index + 1;
        this.totalPages = panacheQuery.pageCount();
    }

}
