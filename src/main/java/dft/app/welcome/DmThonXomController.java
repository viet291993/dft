package dft.app.welcome;

import dft.domain.dto.dmThonXom.DmThonXomDTO;
import dft.domain.model.DmQuanHuyen;
import dft.domain.model.DmThonXom;
import dft.domain.model.DmXaPhuong;
import dft.domain.service.DmQuanHuyenService;
import dft.domain.service.DmThonXomService;
import dft.domain.service.DmXaPhuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/dm-thonxom/")
public class DmThonXomController {

    @Autowired
    private DmQuanHuyenService dmQuanHuyenService;

    @Autowired
    private DmXaPhuongService dmXaPhuongService;

    @Autowired
    private DmThonXomService dmThonXomService;

    /*Tạo Object List các tỉnh, TP*/
    /*Tạo Object List các huyện, quận*/
    @ModelAttribute("dmQuanHuyen_List")
    public List<DmQuanHuyen> danhSachQuanHuyen() {
        return dmQuanHuyenService.findAll();
    }

    /*Tạo Object List các xã, phường*/
    @ModelAttribute("dmXaPhuong_List")
    public List<DmXaPhuong> danhSachXaPhuong() {
        return dmXaPhuongService.findAll();
    }


    /*Chức năng: Lấy danh sách thôn xóm */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listDmThonXom(Model model) throws Exception {
        List<DmThonXom> dmThonXoms = dmThonXomService.findAll();

        List<DmThonXomDTO> dmThonXomDTOS = new ArrayList<>();
        DmThonXomDTO dmThonXomDTO = new DmThonXomDTO();
        for (DmThonXom thonxom : dmThonXoms) {
            int id = thonxom.getId();
            String ten = thonxom.getTenThon();
            String moTa = thonxom.getMoTaThon();
            String maTinh = thonxom.getMaTinh();
            String maHuyen = thonxom.getMaHuyen();
            String maXa = thonxom.getMaXa();
            int trangThai = thonxom.getTrangThai();

            dmThonXomDTO.setId(id);
            dmThonXomDTO.setTen(ten != null ? ten : "Không có");
            dmThonXomDTO.setMoTaThon(moTa != null ? moTa : "Chưa được mô tả");
            dmThonXomDTO.setTinh(maTinh != null ? "Pending" : "Không tìm thấy");
            dmThonXomDTO.setHuyen(maHuyen != null ? "Pending" : "Không tìm thấy");
            dmThonXomDTO.setXa(maXa != null ? "Pending" : "Không tìm thấy");
            dmThonXomDTO.setTrangThai(trangThai == 0 ? "Đang hoạt động" : "Dừng hoạt động");
        }
        dmThonXomDTOS.add(dmThonXomDTO);
        model.addAttribute("DmThonXoms", dmThonXomDTOS);
        return "DmThonXom/DmThonXomList";
    }


    /*Chức năng: Tạo thôn, xóm mới*/
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createThonXomForm() {
        return "DmThonXom/DmThonXomCreate";
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createThonXom(@ModelAttribute("dmThonXomDTO") DmThonXomDTO dmThonXomDTO, Model model) {
        DmThonXom dmThonXom = new DmThonXom();

        dmThonXom.setTenThon(dmThonXomDTO.getTen());
        dmThonXom.setMaTinh("");
        dmThonXom.setMaHuyen("");
        dmThonXom.setMaXa("");
        dmThonXom.setTrangThai(0);

        dmThonXomService.create(dmThonXom);
        model.addAttribute("message", "Thêm Thôn, Xóm thành công");
        return "DmThonXom/DmThonXomCreate";
    }


    /*Chức năng: Xóa thôn, xóm theo id*/
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteDmThonXomById(@PathVariable("id") int dmThonXomId, Model model) {
        dmThonXomService.deleteById(dmThonXomId);
        return "redirect:/dm-thonxom/list";
    }


    /*Chức năng: Update thôn, xóm theo id*/
    @RequestMapping(value = "edit/{id}")
    public String editDmThonXomById(@PathVariable("id") int dmThonXomId, Model model) throws Exception {
        DmThonXom dmThonXom = dmThonXomService.findById(dmThonXomId);
        DmThonXomDTO dmThonXomDTO = new DmThonXomDTO();

        dmThonXomDTO.setTen(dmThonXom.getTenThon());
        dmThonXomDTO.setTinh("");
        dmThonXomDTO.setHuyen("");
        dmThonXomDTO.setXa("");
        dmThonXomDTO.setTrangThai(dmThonXom.getTrangThai() == 1 ? "Đang hoạt động" : "Dừng hoạt động");

        model.addAttribute("dmThonXom", dmThonXomDTO);
        return "DmThonXom/DmThonXomEdit";
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("dmThonXom") DmThonXomDTO dmThonXomDTO, Model model) throws Exception {
        DmThonXom dmThonXom = new DmThonXom();

        dmThonXom.setTenThon(dmThonXomDTO.getTen());
        dmThonXom.setMoTaThon(dmThonXomDTO.getMoTaThon());
        dmThonXom.setMaTinh("");
        dmThonXom.setMaHuyen("");
        dmThonXom.setMaXa("");
        dmThonXom.setTrangThai(0);

        dmThonXomService.update(dmThonXom);
        return "redirect:/dm-thonxom/list";
    }

    /*Chức năng: Tìm kiếm => Trả về danh sách theo từ khóa tìm được*/
    @RequestMapping(value = "listSearch", method = RequestMethod.GET)
    public String listThonXomByWord(@RequestParam("search") Optional<String> search, Pageable pageable, Model model) {
        Page<DmThonXom> dmThonXoms;
        dmThonXoms = dmThonXomService.findAllByMaTinhOrMaHuyenOrMaXa(search.get(), pageable);
        model.addAttribute("DmThonXoms", dmThonXoms);
        return "DmThonXom/DmThonXomList";
    }
}
