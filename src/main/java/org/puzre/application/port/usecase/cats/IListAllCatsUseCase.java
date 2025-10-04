package org.puzre.application.port.usecase.cats;

import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;

public interface IListAllCatsUseCase {
    Page<Cat> execute(Integer page, Integer size);
}
