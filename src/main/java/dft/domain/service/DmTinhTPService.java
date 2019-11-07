package dft.domain.service;

import dft.domain.model.DmQuanHuyen;
import dft.domain.model.DmTinhTP;

import java.util.List;

public interface DmTinhTPService {
    List<DmTinhTP> findAll();

    DmTinhTP findOne(int id);

    boolean create(DmTinhTP mmTinhTP);

    boolean update(DmTinhTP mmTinhTP, String ma);

    boolean deleteById(int id);
}
