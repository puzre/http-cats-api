package org.puzre.adapter.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.resource.dto.response.PaginatedResponse;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;
import org.puzre.core.exception.CatNotFoundException;
import org.puzre.core.port.mapper.repository.IEntityToDomainMapper;
import org.puzre.core.port.repository.ICatRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class CatRepository implements PanacheRepository<CatEntity>, ICatRepository {

    private final IEntityToDomainMapper<CatEntity, Cat> iCatEntityToDomainMapper;

    public CatRepository(
            IEntityToDomainMapper<CatEntity, Cat> iCatEntityToDomainMapper
    ) {
        this.iCatEntityToDomainMapper = iCatEntityToDomainMapper;
    }

    @Override
    public List<Cat> listAllCatsLegacy() {
        return this.listAll().stream()
                .map(iCatEntityToDomainMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Cat> listAllCats(Integer page, Integer totalItems) {

        io.quarkus.panache.common.Page p = new io.quarkus.panache.common.Page(page - 1, totalItems);

        PanacheQuery<CatEntity> panacheQuery = this.findAll().page(p);

        List<Cat> data = panacheQuery.stream()
                .map(CatEntity::toCat)
                .toList();

        return new Page<>(panacheQuery.page().index + 1, panacheQuery.pageCount(), data);

    }

    @Override
    public List<Cat> listCatsLegacyByType(int typeId) {
        return this.list("type.id = ?1", typeId).stream()
                .map(CatEntity::toCat)
                .collect(Collectors.toList());
    }

    @Override
    public PaginatedResponse<CatEntity, Cat> listCatsByType(int typeId, int page, int totalItems) {

        io.quarkus.panache.common.Page p = new io.quarkus.panache.common.Page(page - 1, totalItems);

        PanacheQuery<CatEntity> panacheQuery = this.find("type.id = ?1", typeId).page(p);

        List<Cat> data = panacheQuery.stream()
                .map(CatEntity::toCat)
                .toList();

        return new PaginatedResponse<>(panacheQuery, data);

    }

    @Override
    public Optional<Cat> findCatById(Long id) {
        return this.findByIdOptional(id).map(iCatEntityToDomainMapper::toDomain);
    }

    @Override
    public List<Cat> searchCatsByMessageLegacy(String message) {
        return this.list("message like ?1", "%"+message+"%").stream()
                .map(iCatEntityToDomainMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public PaginatedResponse<CatEntity, Cat> searchCatsByMessage(String message, int page, int totalItems) {

        io.quarkus.panache.common.Page p = new io.quarkus.panache.common.Page(page - 1, totalItems);

        PanacheQuery<CatEntity> panacheQuery = this.find("message like ?1", "%"+message+"%").page(p);

        List<Cat> data = panacheQuery.stream()
                .map(CatEntity::toCat)
                .toList();

        return new PaginatedResponse<>(panacheQuery, data);
    }

}
