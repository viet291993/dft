package dft.domain.service;

import dft.domain.model.DmQuanHuyen;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Transactional
@Service
public class DmQuanHuyenServiceImpl implements DmQuanHuyenService {

    @Inject
    DmQuanHuyenService dmQuanHuyenService;

    @Override
    public List<DmQuanHuyen> getAll() {
        try {
            return dmQuanHuyenService.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Class findOne(int id) {
        try {
            return dmQuanHuyenService.findOne(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean create(DmQuanHuyen dmQuanHuyen) {
        try {
            dmQuanHuyenService.create(dmQuanHuyen);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateById(DmQuanHuyen dmQuanHuyen) {
        try {
            dmQuanHuyenService.updateById(dmQuanHuyen);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        try {
            dmQuanHuyenService.deleteById(id);
            return  true;
        }catch (Exception e){
            return  false;
        }
    }
}
