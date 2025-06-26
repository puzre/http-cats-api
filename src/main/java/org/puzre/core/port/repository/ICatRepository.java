package org.puzre.core.port.repository;

import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.resource.response.PaginatedResponse;
import org.puzre.core.domain.Cat;

import java.util.List;

public interface ICatRepository {

    List<Cat> listAllCatsLegacy();
    PaginatedResponse<CatEntity, Cat> listAllCats(int page, int totalItems);
    List<Cat> listCatsLegacyByType(int typeId);
    PaginatedResponse<CatEntity, Cat> listCatsByType(int typeId, int page, int totalItems);
    Cat findById(int id);

}
