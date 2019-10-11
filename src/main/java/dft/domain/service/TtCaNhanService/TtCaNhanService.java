package dft.domain.service.TtCaNhanService;

import dft.domain.model.DmQuanHuyen;
import dft.domain.model.TtCaNhan;

import java.util.List;

public interface TtCaNhanService {
    List<TtCaNhan> findAllTtCaNhan();
    List<DmQuanHuyen> findAllTinh();
    List<DmQuanHuyen> findAllQuanHuyen();
    List<DmQuanHuyen> findAllThonXom();
    TtCaNhan findOneById(Long id);
    int findOneByMaYTeCaNhan(String maYTeCaNhan);
    String findMaYTeCaNhanById(Long id);
    void insert(TtCaNhan ttCaNhan);
    void update(TtCaNhan ttCaNhan);
    void delete(Long id);

}
