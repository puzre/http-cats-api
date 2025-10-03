package org.puzre.application.usecase.cats;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.puzre.application.port.repository.ICatRepository;
import org.puzre.application.port.usecase.cats.IListCatsByTypeIdUseCase;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;

@Singleton
@RequiredArgsConstructor
public class ListCatsByTypeIdUseCase implements IListCatsByTypeIdUseCase {

    private final ICatRepository iCatRepository;

    @Override
    public Page<Cat> execute(Long typeId, Integer page, Integer size) {
        return iCatRepository.listCatsByTypeId(typeId, page, size);
    }
}
