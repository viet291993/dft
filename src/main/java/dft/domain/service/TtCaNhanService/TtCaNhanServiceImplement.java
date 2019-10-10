package dft.domain.service.TtCaNhanService;

import dft.domain.model.DmQuanHuyen;
import dft.domain.model.TtCaNhan;
import dft.domain.repository.TtCaNhanRepository.TtCaNhanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
public class TtCaNhanServiceImplement implements TtCaNhanService {
    @Inject
    TtCaNhanRepository ttCaNhanRepository;

    @Override
    public List<TtCaNhan> findAllTtCaNhan() {
        return ttCaNhanRepository.findAllTtCaNhan();
    }

    @Override
    public List<DmQuanHuyen> findAllTinh() {
        return ttCaNhanRepository.findAllTinh();
    }

    @Override
    public List<DmQuanHuyen> findAllQuanHuyen() {
        return ttCaNhanRepository.findAllQuanHuyen();
    }

    @Override
    public List<DmQuanHuyen> findAllThonXom() {
        return ttCaNhanRepository.findAllThonXom();
    }

    @Override
    public void insert(TtCaNhan ttCaNhan) {
        ttCaNhanRepository.insert(ttCaNhan);
    }

    @Override
    public int findOne(String maYTeCaNhan) {
        return ttCaNhanRepository.findOne(maYTeCaNhan);
    }

    @Override
    public void update(TtCaNhan ttCaNhan) {
        ttCaNhanRepository.insert(ttCaNhan);
    }
}
