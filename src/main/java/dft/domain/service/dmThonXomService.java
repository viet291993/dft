package dft.domain.service;

import dft.domain.model.DM_THON_XOM;

import java.util.List;

public interface dmThonXomService {
    public List<DM_THON_XOM> findAllThonXom();
    public DM_THON_XOM findOneTonXom();
    public void createThonXom(DM_THON_XOM dm_thon_xom);
    public void updateThonXom(DM_THON_XOM dm_thon_xom);
    public void deleteThonXom(long id);
}
