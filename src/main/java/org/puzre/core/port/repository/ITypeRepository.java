package org.puzre.core.port.repository;

import org.puzre.core.domain.Type;

import java.util.List;
import java.util.Optional;

public interface ITypeRepository {

    List<Type> listAllTypes();
    Optional<Type> findTypeById(Long id);

}
