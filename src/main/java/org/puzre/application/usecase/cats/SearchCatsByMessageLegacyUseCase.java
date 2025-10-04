package org.puzre.application.usecase.cats;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.puzre.application.port.repository.ICatRepository;
import org.puzre.application.port.usecase.cats.ISearchCatsByMessageLegacyUseCase;
import org.puzre.core.domain.Cat;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class SearchCatsByMessageLegacyUseCase implements ISearchCatsByMessageLegacyUseCase {

    private final ICatRepository iCatRepository;

    @Override
    public List<Cat> execute(String message) {
        return iCatRepository.searchCatsByMessageLegacy(message);
    }
}
