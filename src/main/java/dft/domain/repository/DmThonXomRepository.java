package dft.domain.repository;

import dft.domain.model.DM_THON_XOM;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DmThonXomRepository {
  public List<DM_THON_XOM> findAllThonXom();
  public DM_THON_XOM findOneTonXom();
  public void createThonXom(DM_THON_XOM dm_thon_xom);
  public void updateThonXom(DM_THON_XOM dm_thon_xom);
  public void deleteThonXom(long id);
}
