package dft.domain.service.TtCaNhanService;

import dft.domain.model.DmQuanHuyen;
import dft.domain.model.TtCaNhan;

import java.util.List;

public interface TtCaNhanService {
    List<TtCaNhan> findAllTtCaNhan();
    List<DmQuanHuyen> findAllQuanHuyen();
    List<DmQuanHuyen> findAllTinh();
    List<DmQuanHuyen> findAllThonXom();
    void insert(TtCaNhan ttCaNhan);
    int findOne(String maYTeCaNhan);
    void update(TtCaNhan ttCaNhan);
}
