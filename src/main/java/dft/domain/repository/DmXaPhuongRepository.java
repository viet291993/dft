package dft.domain.repository;

import dft.domain.model.DmXaPhuong;
import org.apache.ibatis.annotations.Param;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DmXaPhuongRepository {
    List<DmXaPhuong> findAll();

    List<DmXaPhuong> findByMaQuanHuyen (@Param("maTinh") String maTinh,@Param("maQuanHuyen") String maQuanHuyen);
}
