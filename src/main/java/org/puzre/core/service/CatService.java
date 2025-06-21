package org.puzre.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.resource.response.PaginatedResponse;
import org.puzre.core.domain.Cat;
import org.puzre.core.port.repository.ICatRepository;
import org.puzre.core.port.service.ICatService;

import java.util.List;

@ApplicationScoped
public class CatService implements ICatService {

    private final ICatRepository iCatRepository;

    public CatService(ICatRepository iCatRepository) {
        this.iCatRepository = iCatRepository;
    }

    @Override
    public List<Cat> listAllCatsLegacy() {
        return iCatRepository.listAllCatsLegacy();
    }

    @Override
    public PaginatedResponse<CatEntity, Cat> listAllCats(int page, int totalItems) {
        return iCatRepository.listAllCats(page, totalItems);
    }

    @Override
    public List<Cat> listCatsLegacyByType(int typeId) {
        return iCatRepository.listCatsLegacyByType(typeId);
    }

}
