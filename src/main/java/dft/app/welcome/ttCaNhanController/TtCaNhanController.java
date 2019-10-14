package dft.app.welcome.ttCaNhanController;

import dft.app.welcome.ttCaNhanController.functionTtCaNhanController.FunctionTtCaNhanController;
import dft.domain.dto.ttCaNhanDTO.TtCaNhanDTO;
import dft.domain.model.*;
import dft.domain.service.TtCaNhanService.TtCaNhanService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/ttCaNhan")
public class TtCaNhanController {
    @Inject
    TtCaNhanService ttCaNhanService;

    @GetMapping(value = "/")
    public String showAllTtCaNhan(Model model) {
        FunctionTtCaNhanController.loadLaiTrang(model, false, ttCaNhanService, false);
        return "ttCaNhan/ttCaNhan";
    }

    //<editor-fold defaultstate="collapsed" desc="thêm, sửa, xóa">
    @PostMapping(value = "/", params = "btnThem")
    public String them(@Validated @ModelAttribute("ttCaNhanDTO") TtCaNhanDTO ttCaNhanDTO, BindingResult br, Model model) {
        TtCaNhan ttCaNhan = FunctionTtCaNhanController.kiemTra(ttCaNhanDTO, br, model, ttCaNhanService, false);
        if (ttCaNhan == null) {
            FunctionTtCaNhanController.loadLaiTrang(model, true, ttCaNhanService, false);
            return "ttCaNhan/ttCaNhan";
        }

        // thêm 1 cá nhân vào csdl và load lại các combobox, bảng
        ttCaNhanService.insert(ttCaNhan);
        FunctionTtCaNhanController.loadLaiTrang(model, false, ttCaNhanService, false);
        return "ttCaNhan/ttCaNhan";
    }

    @PostMapping(value = "/", params = "btnSua")
    public String sua(@RequestParam("txtId") Long id, Model model) {
        // lấy ra tt cá nhân được chọn sửa
        // chuyển entity thành dto
        TtCaNhan ttCaNhan = ttCaNhanService.findOneById(id);
        TtCaNhanDTO ttCaNhanDTO = new TtCaNhanDTO();
        BeanUtils.copyProperties(ttCaNhan, ttCaNhanDTO, "ngaySinh");
        ttCaNhanDTO.setNgaySinh(FunctionTtCaNhanController.chuyenNgaySinhThanhString(ttCaNhan.getNgaySinh()));

        // đưa thông tin của cá nhân muốn sửa về trang ttCaNhanSua.jsp
        model.addAttribute("ttCaNhanSuaDTO", ttCaNhanDTO);

        // load trang sửa thông tin cá nhân
        // không load lại danh sách thông tin cá nhân và ttCaNhanDTO
        FunctionTtCaNhanController.loadLaiTrang(model, true, ttCaNhanService, true);

        return "ttCaNhan/ttCaNhanSua";
    }

    @PostMapping(value = "/", params = "btnXoa")
    public String xoa(Model model, @RequestParam("txtId") Long id) {
        // tìm xem thông tin cá nhân muốn xóa có thông tin thương tích nào không
//        int soThuongTich = ttCaNhanService.findOneTtThuongTich(id);
//        if (soThuongTich != 0) {
//            model.addAttribute("xoaError", "Không được xóa thông tin cá nhân này");
//            FunctionTtCaNhanController.loadLaiTrang(model, false, ttCaNhanService, false);
//            return "ttCaNhan/ttCaNhan";
//        }

        // nếu không có thông tin thương tích nào thì xóa
        ttCaNhanService.delete(id);
        FunctionTtCaNhanController.loadLaiTrang(model, false, ttCaNhanService, false);
        return "ttCaNhan/ttCaNhan";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ajax controller">
    @GetMapping(value = "/ajax/quanHuyens")
    public @ResponseBody
    List<DmQuanHuyen> quanHuyens (@RequestParam("idTinh") Long idTinh) {
        // lấy mã tỉnh vì tỉnh 1-n huyện và nối vs nhau bằng mã chứ không phải id
        String maTinh = ttCaNhanService.findMaTinh(idTinh);

        return ttCaNhanService.findAllQuanHuyen(maTinh);
    }

    @GetMapping(value = "/ajax/xaPhuongs")
    public @ResponseBody List<DmXaPhuong> xaPhuongs (@RequestParam("idQuanHuyen") Long idQuanHuyen) {
        String maQuanHuyen = ttCaNhanService.findMaQuanHuyen(idQuanHuyen);
        return ttCaNhanService.findAllXaPhuong(maQuanHuyen);
    }

    @GetMapping(value = "/ajax/thonXoms")
    public @ResponseBody List<DmThonXom> thonXoms (@RequestParam("idXaPhuong") Long idXaPhuong) {
        return ttCaNhanService.findAllThonXom(String.valueOf(idXaPhuong));
    }
    //</editor-fold>
}
