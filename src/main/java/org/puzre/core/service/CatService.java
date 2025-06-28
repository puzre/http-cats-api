package org.puzre.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.resource.response.PaginatedResponse;
import org.puzre.core.domain.Cat;
import org.puzre.core.port.repository.ICatRepository;
import org.puzre.core.port.service.ICatService;
import org.puzre.core.port.service.ITypeService;
import org.puzre.core.port.service.IValidateService;

import java.util.List;

@ApplicationScoped
public class CatService implements ICatService {

    private final ICatRepository iCatRepository;
    private final IValidateService iValidateService;
    private final ITypeService iTypeService;

    public CatService(ICatRepository iCatRepository,
                      IValidateService iValidateService,
                      ITypeService iTypeService) {
        this.iCatRepository = iCatRepository;
        this.iValidateService = iValidateService;
        this.iTypeService = iTypeService;
    }

    @Override
    public List<Cat> listAllCatsLegacy() {
        return iCatRepository.listAllCatsLegacy();
    }

    @Override
    public PaginatedResponse<CatEntity, Cat> listAllCats(int page, int totalItems) {

        iValidateService.validateNumber(page, "page must be a positive value");
        iValidateService.validateNumber(totalItems, "totalItems must be a positive value");

        return iCatRepository.listAllCats(page, totalItems);
    }

    @Override
    public List<Cat> listCatsLegacyByType(int typeId) {

        iValidateService.validateNumber(typeId, "typeId must be a positive value");

        iTypeService.findTypeById(typeId);

        return iCatRepository.listCatsLegacyByType(typeId);
    }

    @Override
    public PaginatedResponse<CatEntity, Cat> listCatsByType(int typeId, int page, int totalItems) {

        iValidateService.validateNumber(page, "page must be a positive value");
        iValidateService.validateNumber(totalItems, "totalItems must be a positive value");
        iValidateService.validateNumber(typeId, "typeId must be a positive value");

        iTypeService.findTypeById(typeId);

        return iCatRepository.listCatsByType(typeId, page, totalItems);
    }

    @Override
    public Cat findCatById(int catId) {

        iValidateService.validateNumber(catId, "catId must be a positive value");

        return iCatRepository.findById(catId);
    }

    @Override
    public List<Cat> searchCatsByMessageLegacy(String message) {

        iValidateService.validateString(message, "message must not be empty");

        return iCatRepository.searchCatsByMessageLegacy(message);
    }

}
