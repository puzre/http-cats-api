package org.puzre.core.port.service;

import org.puzre.core.domain.Type;

import java.util.List;

public interface ITypeService {

    List<Type> listAllTypes();
    Type findTypeById(Long typeId);

}
