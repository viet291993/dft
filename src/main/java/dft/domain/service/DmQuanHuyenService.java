package dft.domain.service;

import dft.domain.model.DmQuanHuyen;

import java.util.List;

public interface DmQuanHuyenService {
    List<DmQuanHuyen> getAll();

    Class findOne(int id);

    boolean create(DmQuanHuyen dmQuanHuyen);

    boolean updateById(DmQuanHuyen dmQuanHuyen);

    boolean deleteById(int id);
}
