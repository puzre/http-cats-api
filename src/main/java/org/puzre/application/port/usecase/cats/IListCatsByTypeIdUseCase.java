package org.puzre.application.port.usecase.cats;

import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;

public interface IListCatsByTypeIdUseCase {
    Page<Cat> execute(Long typeId, Integer page, Integer size);
}
