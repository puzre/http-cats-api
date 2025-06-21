package org.puzre.adapter.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.resource.response.PaginatedResponse;
import org.puzre.core.domain.Cat;
import org.puzre.core.port.repository.ICatRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CatRepository implements PanacheRepository<CatEntity>, ICatRepository {

    @Override
    public List<Cat> listAllCatsLegacy() {
        return this.listAll().stream()
                .map(CatEntity::toCat)
                .collect(Collectors.toList());
    }

    @Override
    public PaginatedResponse<CatEntity, Cat> listAllCats(int page, int totalItems) {

        Page p = new Page(page - 1, totalItems);

        PanacheQuery<CatEntity> panacheQuery = this.findAll().page(p);

        List<Cat> data = panacheQuery.stream()
                .map(CatEntity::toCat)
                .toList();

        return new PaginatedResponse<>(panacheQuery, data);

    }

}
