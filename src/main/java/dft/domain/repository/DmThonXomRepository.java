package dft.domain.repository;

import dft.domain.model.DmThonXom;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DmThonXomRepository {
    List<DmThonXom> findAll();

    DmThonXom findById(int id);

    void create(DmThonXom dmThonXom);

    DmThonXom updateById(int id);

    void deleteById(int id);
}
