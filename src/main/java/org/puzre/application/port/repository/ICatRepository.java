package org.puzre.application.port.repository;

import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ICatRepository {

    List<Cat> listAllCatsLegacy();
    Page<Cat> listAllCats(Integer page, Integer totalItems);
    List<Cat> listCatsByTypeIdLegacy(Long typeId);
    Page<Cat> listCatsByTypeId(Long typeId, Integer page, Integer size);
    Optional<Cat> findCatById(Long id);
    List<Cat> searchCatsByMessageLegacy(String message);
    Page<Cat> searchCatsByMessage(String message, int page, int totalItems);

}
