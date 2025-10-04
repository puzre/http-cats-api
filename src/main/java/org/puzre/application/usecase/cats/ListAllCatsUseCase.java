package org.puzre.application.usecase.cats;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.puzre.application.port.repository.ICatRepository;
import org.puzre.application.port.usecase.cats.IListAllCatsUseCase;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;

@Singleton
@RequiredArgsConstructor
public class ListAllCatsUseCase implements IListAllCatsUseCase {

    private final ICatRepository iCatRepository;

    @Override
    public Page<Cat> execute(Integer page, Integer size) {
        return iCatRepository.listAllCats(page, size);
    }
}
