package org.puzre.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.resource.response.PaginatedResponse;
import org.puzre.core.domain.Cat;
import org.puzre.core.port.repository.ICatRepository;
import org.puzre.core.port.service.ICatService;
import org.puzre.core.port.service.IValidateService;

import java.util.List;

@ApplicationScoped
public class CatService implements ICatService {

    private final ICatRepository iCatRepository;
    private final IValidateService iValidateService;

    public CatService(ICatRepository iCatRepository,
                      IValidateService iValidateService) {
        this.iCatRepository = iCatRepository;
        this.iValidateService = iValidateService;
    }

    @Override
    public List<Cat> listAllCatsLegacy() {
        return iCatRepository.listAllCatsLegacy();
    }

    @Override
    public PaginatedResponse<CatEntity, Cat> listAllCats(int page, int totalItems) {

        iValidateService.validatePaginatedNumber(page, "page must be a positive value");
        iValidateService.validatePaginatedNumber(totalItems, "totalItems must be a positive value");

        return iCatRepository.listAllCats(page, totalItems);
    }

    @Override
    public List<Cat> listCatsLegacyByType(int typeId) {
        return iCatRepository.listCatsLegacyByType(typeId);
    }

    @Override
    public PaginatedResponse<CatEntity, Cat> listCatsByType(int typeId, int page, int totalItems) {

        iValidateService.validatePaginatedNumber(page, "page must be a positive value");
        iValidateService.validatePaginatedNumber(totalItems, "totalItems must be a positive value");

        return iCatRepository.listCatsByType(typeId, page, totalItems);
    }

}
