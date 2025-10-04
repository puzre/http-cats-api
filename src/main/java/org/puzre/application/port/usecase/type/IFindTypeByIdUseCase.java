package org.puzre.application.port.usecase.type;

import org.puzre.core.domain.Type;

public interface IFindTypeByIdUseCase {
    Type execute(Long id);
}
