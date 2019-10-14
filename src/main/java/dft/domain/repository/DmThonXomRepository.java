package dft.domain.repository;

import dft.domain.model.DmThonXom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DmThonXomRepository  {
    List<DmThonXom> findAll();

    List<DmThonXom> findThonXomByMaXaPhuong(String maXaPhuong);

    DmThonXom findById(int id);

    void create(DmThonXom dmThonXom);

    void update(DmThonXom dmThonXom);

    void deleteById(int id);

}
