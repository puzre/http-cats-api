package org.puzre.adapter.resource.response;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

import java.util.List;

public class PaginatedResponse<T> {

    private final List<T> data;
    private final int page;
    private final int totalPages;

    public PaginatedResponse(PanacheQuery<T> panacheQuery) {
        this.data = panacheQuery.stream().toList();
        this.page = panacheQuery.page().index + 1;
        this.totalPages = panacheQuery.pageCount();
    }

}
