package org.puzre.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.adapter.repository.entity.CatEntity;
import org.puzre.adapter.resource.dto.response.PaginatedResponse;
import org.puzre.core.domain.Cat;
import org.puzre.core.domain.Page;
import org.puzre.core.domain.Type;
import org.puzre.core.exception.CatNotFoundException;
import org.puzre.core.exception.TypeNotFoundException;
import org.puzre.core.port.repository.ICatRepository;
import org.puzre.core.port.repository.ITypeRepository;
import org.puzre.core.port.service.ICatService;
import org.puzre.core.port.service.ITypeService;
import org.puzre.core.port.service.IValidateService;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CatService implements ICatService {

    private final ICatRepository iCatRepository;
    private final IValidateService iValidateService;

    private final ITypeRepository iTypeRepository;

    public CatService(ICatRepository iCatRepository,
                      IValidateService iValidateService,
                      ITypeRepository iTypeRepository) {
        this.iCatRepository = iCatRepository;
        this.iValidateService = iValidateService;
        this.iTypeRepository = iTypeRepository;
    }

    @Override
    public List<Cat> listAllCatsLegacy() {
        return iCatRepository.listAllCatsLegacy();
    }

    @Override
    public Page<Cat> listAllCats(Integer page, Integer totalItems) {
        return iCatRepository.listAllCats(page, totalItems);
    }

    @Override
    public List<Cat> listCatsLegacyByType(Long typeId) {

        Type type = iTypeRepository.findTypeById(typeId)
                .orElseThrow(() -> new TypeNotFoundException("type not found for key -> " + typeId));

        return iCatRepository.listCatsLegacyByType(Long.parseLong(String.valueOf(type.getId())));
    }

    @Override
    public Page<Cat> listCatsByType(Long typeId, Integer page, Integer size) {

        Type type = iTypeRepository.findTypeById(Long.parseLong(String.valueOf(typeId)))
                .orElseThrow(() -> new TypeNotFoundException("type not found for key -> " + typeId));

        return iCatRepository.listCatsByType(Long.parseLong(String.valueOf(type.getId())), page, size);
    }

    @Override
    public Cat findCatById(Long catId) {
        return iCatRepository.findCatById(catId).orElseThrow(() -> new CatNotFoundException("cat not found for key -> " + catId));
    }

    @Override
    public List<Cat> searchCatsByMessageLegacy(String message) {
        return iCatRepository.searchCatsByMessageLegacy(message);
    }

    @Override
    public Page<Cat> searchCatsByMessage(String message, int page, int totalItems) {
        return iCatRepository.searchCatsByMessage(message, page, totalItems);
    }


}
