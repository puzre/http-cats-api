package org.puzre.application.port.usecase.types;

import org.puzre.core.domain.Type;

import java.util.List;

public interface IListAllTypesUseCase {
    List<Type> execute();
}
