package org.puzre.application.usecase.cats;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.puzre.application.port.repository.ICatRepository;
import org.puzre.application.port.usecase.cats.ISearchCatsByMessageUseCase;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;

@Singleton
@RequiredArgsConstructor
public class SearchCatsByMessageUseCase implements ISearchCatsByMessageUseCase {

    private final ICatRepository iCatRepository;

    @Override
    public Page<Cat> execute(String message, Integer page, Integer size) {
        return iCatRepository.searchCatsByMessage(message, page, size);
    }
}
