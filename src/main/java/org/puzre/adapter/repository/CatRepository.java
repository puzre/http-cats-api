package org.puzre.adapter.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.repository.mapper.CatEntityToDomainMapper;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;
import org.puzre.application.port.repository.ICatRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class CatRepository implements PanacheRepository<CatEntity>, ICatRepository {

    private final CatEntityToDomainMapper catEntityToDomainMapper;

    @Override
    public List<Cat> listAllCatsLegacy() {
        return this.listAll().stream()
                .map(catEntityToDomainMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Cat> listAllCats(Integer page, Integer size) {

        io.quarkus.panache.common.Page p = new io.quarkus.panache.common.Page(page - 1, size);

        PanacheQuery<CatEntity> panacheQuery = this.findAll().page(p);

        List<Cat> data = panacheQuery.stream()
                .map(catEntityToDomainMapper::toDomain)
                .toList();

        return new Page<>(panacheQuery.page().index + 1, panacheQuery.pageCount(), data);

    }

    @Override
    public List<Cat> listCatsByTypeIdLegacy(Long typeId) {
        return this.list("type.id = ?1", typeId).stream()
                .map(catEntityToDomainMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Cat> listCatsByTypeId(Long typeId, Integer page, Integer size) {

        io.quarkus.panache.common.Page p = new io.quarkus.panache.common.Page(page - 1, size);

        PanacheQuery<CatEntity> panacheQuery = this.find("type.id = ?1", typeId).page(p);

        List<Cat> data = panacheQuery.stream()
                .map(catEntityToDomainMapper::toDomain)
                .toList();

        return new Page<>(panacheQuery.page().index + 1, panacheQuery.pageCount(), data);

    }

    @Override
    public Optional<Cat> findCatById(Long id) {
        return this.findByIdOptional(id).map(catEntityToDomainMapper::toDomain);
    }

    @Override
    public List<Cat> searchCatsByMessageLegacy(String message) {
        return this.list("message like ?1", "%"+message+"%").stream()
                .map(catEntityToDomainMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Cat> searchCatsByMessage(String message, int page, int size) {

        io.quarkus.panache.common.Page p = new io.quarkus.panache.common.Page(page - 1, size);

        PanacheQuery<CatEntity> panacheQuery = this.find("message like ?1", "%"+message+"%").page(p);

        List<Cat> data = panacheQuery.stream()
                .map(catEntityToDomainMapper::toDomain)
                .toList();

        return new Page<>(panacheQuery.page().index + 1, panacheQuery.pageCount(), data);
    }

}
