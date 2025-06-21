package org.puzre.adapter.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.adapter.repository.entity.CatEntity;
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

}
