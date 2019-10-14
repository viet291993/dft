package dft.domain.service;

import dft.domain.model.DmThonXom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DmThonXomService {
    List<DmThonXom> findAll();

    DmThonXom findById(int id);

    void create(DmThonXom dmThonXom);

    void update(DmThonXom dmThonXom);

    void deleteById(int id);

    Page<DmThonXom> findAllByMaTinhOrMaHuyenOrMaXa(String name, Pageable pageable);
}
