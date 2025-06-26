package org.puzre.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.puzre.core.domain.Type;
import org.puzre.core.port.repository.ITypeRepository;
import org.puzre.core.port.service.ITypeService;

import java.util.List;

@ApplicationScoped
public class TypeService implements ITypeService {

    private final ITypeRepository iTypeRepository;

    public TypeService(ITypeRepository iTypeRepository) {
        this.iTypeRepository = iTypeRepository;
    }

    @Override
    public List<Type> listAllTypes() {
        return iTypeRepository.listAllTypes();
    }

    @Override
    public Type findTypeById(int id) {
        return iTypeRepository.findById(id);
    }

}
