package org.puzre.application.usecase.types;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.puzre.application.port.repository.ITypeRepository;
import org.puzre.application.port.usecase.types.IListAllTypesUseCase;
import org.puzre.core.domain.Type;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class ListAllTypesUseCase implements IListAllTypesUseCase {

    private final ITypeRepository iTypeRepository;

    @Override
    public List<Type> execute() {
        return iTypeRepository.listAllTypes();
    }
}
