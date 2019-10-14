package dft.domain.service;

import dft.domain.model.DmThonXom;
import dft.domain.repository.DmThonXomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
public class DmThonXomServiceImpl implements DmThonXomService {
    @Inject
    private DmThonXomRepository dmThonXomRepository;

    @Override
    public List<DmThonXom> findAll() {
        return dmThonXomRepository.findAll();
    }

    @Override
    public DmThonXom findById(int id) {
        return dmThonXomRepository.findById(id);
    }

    @Override
    public void create(DmThonXom dmThonXom) {
        dmThonXomRepository.create(dmThonXom);
    }

    @Override
    public void update(DmThonXom dmThonXom) {
        dmThonXomRepository.update(dmThonXom);
    }


    @Override
    public void deleteById(int id) {
        dmThonXomRepository.deleteById(id);
    }

    @Override
    public Page<DmThonXom> findAllByMaTinhOrMaHuyenOrMaXa(String name, Pageable pageable) {
        return dmThonXomRepository.findAllByMaTinhOrMaHuyenOrMaXa(name, pageable);
    }
}
