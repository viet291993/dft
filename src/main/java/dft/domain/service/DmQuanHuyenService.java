package dft.domain.service;

import dft.domain.model.DmQuanHuyen;

import java.util.List;

public interface DmQuanHuyenService {
    List<DmQuanHuyen> findAll();

    DmQuanHuyen findOne(int id);

    boolean create(DmQuanHuyen dmQuanHuyen);

    boolean update(DmQuanHuyen dmQuanHuyen);

    boolean deleteById(int id);
}
