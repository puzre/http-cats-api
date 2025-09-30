package org.puzre.application.port.usecase.cats;

import org.puzre.core.domain.Cat;

import java.util.List;

public interface IListAllCatsLegacyUseCase {
    List<Cat> execute();
}
