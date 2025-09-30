package org.puzre.application.port.usecase.cats;

import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;

public interface ISearchCatsByMessageUseCase {
    Page<Cat> execute(String message, Integer page, Integer size);
}
