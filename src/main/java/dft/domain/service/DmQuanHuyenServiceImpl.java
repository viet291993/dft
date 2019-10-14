package dft.domain.service;

import dft.domain.model.DmQuanHuyen;
import dft.domain.repository.DmQuanHuyenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Transactional
@Service
public class DmQuanHuyenServiceImpl implements DmQuanHuyenService {

    @Inject
    DmQuanHuyenRepository dmQuanHuyenRepository;

    // Lấy danh sách Quận Huyện
    @Override
    public List<DmQuanHuyen> findAll() {
        try {
            return dmQuanHuyenRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Lấy thông tin Quận Huyên theo id
     * @param id <id>
     * @return DmQuanHuyen
     */
    @Override
    public DmQuanHuyen findOne(int id) {
        try {
            return dmQuanHuyenRepository.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Thêm mới Quận Huyện
     * @param dmQuanHuyen
     * @return boolean <true: thêm mới thành công , false: thêm mới thất bại >
     */
    @Override
    public boolean create(DmQuanHuyen dmQuanHuyen) {
        try {
            dmQuanHuyenRepository.create(dmQuanHuyen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Sửa thông tin Quận Huyện
     * @param dmQuanHuyen
     * @return boolean <true: Sửa thành công , false: Sửa  thất bại >
     */
    @Override
    public boolean update(DmQuanHuyen dmQuanHuyen) {
        try {
            dmQuanHuyenRepository.update(dmQuanHuyen);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Xóa Quận Huyện
     * @param id <id của Quận Huyện>
     * @return boolean <true: Xóa thành công , false: Xóa thất bại >
     */
    @Override
    public boolean deleteById(int id) {
        try {
            dmQuanHuyenRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
