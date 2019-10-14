package dft.domain.service;

import dft.domain.model.DmXaPhuong;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DmXaPhuongService {
    List<DmXaPhuong> findAll();
    List<DmXaPhuong> findByMaQuanHuyen (String maQuanHuyen);
}
