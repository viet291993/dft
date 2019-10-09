package dft.domain.service.TtCaNhanService;

import dft.domain.model.TtCaNhan;
import dft.domain.repository.TtCaNhanRepository.TtCaNhanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class TtCaNhanServiceImplement implements TtCaNhanService {
    @Inject
    TtCaNhanRepository ttCaNhanRepository;

    @Override
    public TtCaNhan findAllTtCaNhan() {
        return ttCaNhanRepository.findAllTtCaNhan();
    }
}
