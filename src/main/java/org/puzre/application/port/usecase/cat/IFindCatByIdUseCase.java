package org.puzre.application.port.usecase.cat;

import org.puzre.core.domain.Cat;

public interface IFindCatByIdUseCase {
    Cat execute(Long id);
}
