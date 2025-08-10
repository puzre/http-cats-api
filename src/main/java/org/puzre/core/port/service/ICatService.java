package org.puzre.core.port.service;

import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.resource.dto.response.PaginatedResponse;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;

import java.util.List;

public interface ICatService {

    List<Cat> listAllCatsLegacy();
    Page<Cat> listAllCats(Integer page, Integer totalItems);
    List<Cat> listCatsLegacyByType(int typeId);
    PaginatedResponse<CatEntity, Cat> listCatsByType(int typeId, int page, int totalItems);
    Cat findCatById(Long catId);
    List<Cat> searchCatsByMessageLegacy(String message);
    PaginatedResponse<CatEntity, Cat> searchCatsByMessage(String message, int page, int totalItems);

}
