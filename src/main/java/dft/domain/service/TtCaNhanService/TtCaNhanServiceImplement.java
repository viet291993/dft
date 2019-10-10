package dft.domain.service.TtCaNhanService;

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
}
