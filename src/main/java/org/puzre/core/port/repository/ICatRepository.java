package org.puzre.core.port.repository;

import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.resource.dto.response.PaginatedResponse;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ICatRepository {

    List<Cat> listAllCatsLegacy();
    Page<Cat> listAllCats(Integer page, Integer totalItems);
    List<Cat> listCatsLegacyByType(int typeId);
    PaginatedResponse<CatEntity, Cat> listCatsByType(int typeId, int page, int totalItems);
    Optional<Cat> findCatById(Long id);
    List<Cat> searchCatsByMessageLegacy(String message);
    Page<Cat> searchCatsByMessage(String message, int page, int totalItems);

}
