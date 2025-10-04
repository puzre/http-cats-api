package org.puzre.application.usecase.type;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.puzre.application.port.usecase.type.IFindTypeByIdUseCase;
import org.puzre.core.domain.Type;
import org.puzre.core.exception.TypeNotFoundException;
import org.puzre.application.port.repository.ITypeRepository;

@Singleton
@RequiredArgsConstructor
public class FindTypeByIdUseCase implements IFindTypeByIdUseCase {

    private final ITypeRepository iTypeRepository;

    @Override
    public Type execute(Long id) {
        return iTypeRepository.findTypeById(id)
                .orElseThrow(() -> new TypeNotFoundException("type not found"));
    }
}
