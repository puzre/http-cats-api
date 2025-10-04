package org.puzre.adapter.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.puzre.adapter.repository.entity.TypeEntity;
import org.puzre.adapter.repository.mapper.TypeEntityToDomainMapper;
import org.puzre.core.domain.Type;
import org.puzre.application.port.repository.ITypeRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class TypeRepository implements PanacheRepository<TypeEntity>, ITypeRepository {

    private final TypeEntityToDomainMapper typeEntityToDomainMapper;

    @Override
    public List<Type> listAllTypes() {
        return this.listAll().stream()
                .map(typeEntityToDomainMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Type> findTypeById(Long id) {
        return this.findByIdOptional(id)
                .map(typeEntityToDomainMapper::toDomain);
    }

}
