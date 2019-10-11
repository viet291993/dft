package dft.domain.repository;

import dft.domain.model.DmQuanHuyen;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DmQuanHuyenRepository {

    List<DmQuanHuyen> findAll();

    DmQuanHuyen findOne(int id);

    void create(DmQuanHuyen dmQuanHuyen);

    void update(DmQuanHuyen dmQuanHuyen);

    void deleteById(int id);
}
