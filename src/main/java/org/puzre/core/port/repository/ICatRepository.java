package org.puzre.core.port.repository;

import org.puzre.core.domain.Cat;

import java.util.List;

public interface ICatRepository {

    List<Cat> listAllCats();

}
