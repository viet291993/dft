package dft.app.welcome;

import dft.domain.dto.dmThonXom.DmThonXomDTO;
import dft.domain.model.DmQuanHuyen;
import dft.domain.model.DmThonXom;
import dft.domain.model.DmTinhTP;
import dft.domain.model.DmXaPhuong;
import dft.domain.service.DmQuanHuyenService;
import dft.domain.service.DmThonXomService;
import dft.domain.service.DmTinhTPService;
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
    private DmTinhTPService dmTinhTPService;

    @Autowired
    private DmQuanHuyenService dmQuanHuyenService;

    @Autowired
    private DmXaPhuongService dmXaPhuongService;

    @Autowired
    private DmThonXomService dmThonXomService;

    /*Tạo Object List các tỉnh, TP*/
    @ModelAttribute("dmTinhTP_List")
    public List<DmTinhTP> danhSachTinhTP(){
        return dmTinhTPService.findAll();
    }
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

        List<DmThonXomDTO> dmThonXomDTOS = new ArrayList<DmThonXomDTO>();
        for (DmThonXom thonxom : dmThonXoms) {
            DmThonXomDTO dmThonXomDTO = new DmThonXomDTO();
            int id = thonxom.getId();
            String ten = thonxom.getTen();
            String moTa = thonxom.getMoTa();
            String maTinh = thonxom.getMaTinh();
            String maHuyen = thonxom.getMaHuyen();
            String maXa = thonxom.getMaXa() !=null? thonxom.getMaXa():"";
            int trangThai = thonxom.getTrangThai();

            dmThonXomDTO.setId(id);
            dmThonXomDTO.setTen(ten != null ? ten : "Không có");
            dmThonXomDTO.setMoTaThon(moTa != null ? moTa : "Chưa được mô tả");
            dmThonXomDTO.setTinh(maTinh != null ? dmTinhTPService.findOne(Integer.parseInt(maTinh)).getTen() : "Không tìm thấy");
            dmThonXomDTO.setHuyen(maHuyen != null ? dmQuanHuyenService.findOne(Integer.parseInt(maHuyen)).getTen() : "Không tìm thấy");
            dmThonXomDTO.setXa(maXa != null ? dmXaPhuongService.findById(Integer.parseInt(maXa)).getTen() : "Không tìm thấy");
            dmThonXomDTO.setTrangThai(trangThai ==1?"Đang hoạt động":"Nghỉ");

            dmThonXomDTOS.add(dmThonXomDTO);
        }
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

        dmThonXom.setTen(dmThonXomDTO.getTen());
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
        String maTinh = dmThonXom.getMaTinh();
        String maHuyen = dmThonXom.getMaHuyen();
        String maXa = dmThonXom.getMaXa();
        DmTinhTP dmTinhTP = dmTinhTPService.findOne(Integer.parseInt(maTinh));
        DmQuanHuyen dmQuanHuyen = dmQuanHuyenService.findOne(Integer.parseInt(maHuyen));
        DmXaPhuong dmXaPhuong = dmXaPhuongService.findById(Integer.parseInt(maXa));

        model.addAttribute("tinh",dmTinhTP.getTen());
        model.addAttribute("huyen",dmQuanHuyen.getTen());
        model.addAttribute("xa",dmXaPhuong.getTen());
        model.addAttribute("dmThonXom", dmThonXom);
        return "DmThonXom/DmThonXomEdit";
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("dmThonXom") DmThonXom dmThonXom, Model model) throws Exception {
        dmThonXomService.update(dmThonXom);
        return "redirect:/dm-thonxom/list";
    }

}
