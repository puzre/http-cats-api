package org.puzre.adapter.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.adapter.repository.entity.TypeEntity;
import org.puzre.core.domain.Type;
import org.puzre.adapter.repository.mapper.spi.IEntityToDomainMapper;
import org.puzre.core.port.repository.ITypeRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TypeRepository implements PanacheRepository<TypeEntity>, ITypeRepository {

    private final IEntityToDomainMapper<TypeEntity, Type> iTypeEntityToDomainMapper;

    public TypeRepository(
            IEntityToDomainMapper<TypeEntity, Type> iTypeEntityToDomainMapper
    ) {
        this.iTypeEntityToDomainMapper = iTypeEntityToDomainMapper;
    }

    @Override
    public List<Type> listAllTypes() {
        return this.listAll().stream()
                .map(iTypeEntityToDomainMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Type> findTypeById(Long id) {
        return this.findByIdOptional((long) id)
                .map(TypeEntity::toType);
    }

}
