package org.puzre.application.port.usecase.cats;

import org.puzre.core.domain.Cat;

import java.util.List;

public interface IListCatsByTypeIdLegacyUseCase {
    List<Cat> execute(Long typeId);
}
