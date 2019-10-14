package dft.domain.service;

import dft.domain.model.DmXaPhuong;
import dft.domain.repository.DmXaPhuongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
@Service
@Transactional
public class DmXaPhuongServiceImpl implements DmXaPhuongService{
    @Inject
    DmXaPhuongRepository dmXaPhuongRepository;

    @Override
    public List<DmXaPhuong> findAll() {
        return dmXaPhuongRepository.findAll();
    }

    @Override
    public List<DmXaPhuong> findByMaQuanHuyen(String maQuanHuyen){
        try {
            return dmXaPhuongRepository.findByMaQuanHuyen(maQuanHuyen);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    @Override
    public DmXaPhuong findById(long id){
        return dmXaPhuongRepository.findById(id);
    }

    @Override
    public void deleteById(int id){
        dmXaPhuongRepository.deleteById(id);
    }

    @Override
    public void create(DmXaPhuong dmXaPhuong) {
        dmXaPhuongRepository.create(dmXaPhuong);
    }

    @Override
    public void update(DmXaPhuong dmXaPhuong) {
        dmXaPhuongRepository.update(dmXaPhuong);
    }
}
