package org.puzre.application.usecase.cats;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.puzre.application.port.repository.ICatRepository;
import org.puzre.application.port.usecase.cats.IListAllCatsLegacyUseCase;
import org.puzre.core.domain.Cat;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class ListAllCatsLegacyUseCase implements IListAllCatsLegacyUseCase {

    private final ICatRepository iCatRepository;

    @Override
    public List<Cat> execute() {
        return iCatRepository.listAllCatsLegacy();
    }

}
