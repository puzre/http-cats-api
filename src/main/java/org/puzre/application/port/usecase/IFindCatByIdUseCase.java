package org.puzre.application.port.usecase;

import org.puzre.core.domain.Cat;

public interface IFindCatByIdUseCase {
    Cat execute(Long id);
}
