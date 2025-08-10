package org.puzre.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.core.domain.Type;
import org.puzre.core.exception.TypeNotFoundException;
import org.puzre.core.port.repository.ITypeRepository;
import org.puzre.core.port.service.ITypeService;
import org.puzre.core.port.service.IValidateService;

import java.util.List;

@ApplicationScoped
public class TypeService implements ITypeService {

    private final ITypeRepository iTypeRepository;
    private final IValidateService iValidateService;

    public TypeService(ITypeRepository iTypeRepository,
                       IValidateService iValidateService) {
        this.iTypeRepository = iTypeRepository;
        this.iValidateService = iValidateService;
    }

    @Override
    public List<Type> listAllTypes() {
        return iTypeRepository.listAllTypes();
    }

    @Override
    public Type findTypeById(Long typeId) {
        return iTypeRepository.findTypeById(typeId)
                .orElseThrow(() -> new TypeNotFoundException("type not found for key -> " + typeId));
    }

}
