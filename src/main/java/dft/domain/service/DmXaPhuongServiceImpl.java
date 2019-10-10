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
}
