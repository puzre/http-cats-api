package org.puzre.adapter.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.adapter.repository.entity.TypeEntity;
import org.puzre.core.domain.Type;
import org.puzre.core.port.repository.ITypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TypeRepository implements PanacheRepository<TypeEntity>, ITypeRepository {

    @Override
    public List<Type> listAllTypes() {
        return this.listAll().stream()
                .map(TypeEntity::toType)
                .collect(Collectors.toList());
    }

}
