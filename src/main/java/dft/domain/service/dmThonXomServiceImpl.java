package dft.domain.service;

import dft.domain.model.DM_THON_XOM;
import org.springframework.beans.factory.annotation.Autowired;
import dft.domain.repository.DmThonXomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Transactional
@Service
public class dmThonXomServiceImpl implements dmThonXomService {
    @Inject
    DmThonXomRepository dmThonXomRepository;

    @Override
    public List<DM_THON_XOM> findAllThonXom() {
        return dmThonXomRepository.findAllThonXom();
    }

    @Override
    public DM_THON_XOM findOneTonXom() {
        return dmThonXomRepository.findOneTonXom();
    }

    @Override
    public void createThonXom(DM_THON_XOM dm_thon_xom) {
        dmThonXomRepository.createThonXom(dm_thon_xom);
    }

    @Override
    public void updateThonXom(DM_THON_XOM dm_thon_xom) {
        dmThonXomRepository.updateThonXom(dm_thon_xom);
    }

    @Override
    public void deleteThonXom(long id) {
        dmThonXomRepository.deleteThonXom(id);
    }
}
