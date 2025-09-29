package org.puzre.application.usecase;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.puzre.application.port.repository.ICatRepository;
import org.puzre.application.port.usecase.IFindCatByIdUseCase;
import org.puzre.core.domain.Cat;
import org.puzre.core.exception.CatNotFoundException;

@Singleton
@RequiredArgsConstructor
public class FindCatByIdUseCase implements IFindCatByIdUseCase {

    private final ICatRepository iCatRepository;

    @Override
    public Cat execute(Long id) {
        return iCatRepository.findCatById(id)
                .orElseThrow(()-> new CatNotFoundException("cat not found"));

    }

}
