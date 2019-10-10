package dft.domain.repository;

import dft.domain.model.DmXaPhuong;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DmXaPhuongRepository {
    List<DmXaPhuong> findAll();
}
