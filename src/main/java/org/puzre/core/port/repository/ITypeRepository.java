package org.puzre.core.port.repository;

import org.puzre.core.domain.Type;

import java.util.List;

public interface ITypeRepository {

    List<Type> listAllTypes();

    Type findById(int id);

}
