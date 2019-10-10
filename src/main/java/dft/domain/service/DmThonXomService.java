package dft.domain.service;

import dft.domain.model.DmThonXom;

import java.util.List;

public interface DmThonXomService {
    List<DmThonXom> findAll();

    DmThonXom findById(int id);

    void create(DmThonXom dmThonXom);

    DmThonXom updateById(int id);

    void deleteById(int id);
}
