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
import java.text.*;
import java.util.ArrayList;
import java.util.*;

@Controller
@RequestMapping("/ttCaNhan")
public class TtCaNhanController {
    @Inject
    TtCaNhanService ttCaNhanService;

    @GetMapping(value = "/")
    public String showAllTtCaNhan(Model model) {
        FunctionTtCaNhanController.loadLaiTrang(model, false, ttCaNhanService);

        return "ttCaNhan/ttCaNhan";
    }

    //<editor-fold defaultstate="collapsed" desc="thêm, sửa, xóa">
    @PostMapping(value = "/", params = "btnThem")
    public String them(@Validated @ModelAttribute("ttCaNhanDTO") TtCaNhanDTO ttCaNhanDTO, BindingResult br, Model model) {
        TtCaNhan ttCaNhan = FunctionTtCaNhanController.kiemTra(ttCaNhanDTO, br, model, ttCaNhanService, false);
        if (ttCaNhan == null) {
            FunctionTtCaNhanController.loadLaiTrang(model, true, ttCaNhanService);
            return "ttCaNhan/ttCaNhan";
        }

        // thêm 1 cá nhân vào csdl và load lại các combobox, bảng
        ttCaNhanService.insert(ttCaNhan);
        FunctionTtCaNhanController.loadLaiTrang(model, false, ttCaNhanService);
        return "ttCaNhan/ttCaNhan";
    }

    @PostMapping(value = "/", params = "btnSua")
    public String sua(@RequestParam("txtId") Long id, Model model) {
        // chuyển entity thành dto
        TtCaNhan ttCaNhan = ttCaNhanService.findOneById(id);
        TtCaNhanDTO ttCaNhanDTO = new TtCaNhanDTO();
        BeanUtils.copyProperties(ttCaNhan, ttCaNhanDTO, "ngaySinh");
        ttCaNhanDTO.setNgaySinh(FunctionTtCaNhanController.chuyenNgaySinhThanhString(ttCaNhan.getNgaySinh()));

        // đưa thông tin của cá nhân muốn sửa về trang ttCaNhanSua.jsp
        model.addAttribute("ttCaNhanSuaDTO", ttCaNhanDTO);
        return "ttCaNhan/ttCaNhanSua";
    }

    @PostMapping(value = "/", params = "btnXoa")
    public String xoa(@RequestParam("txtId") Long id, Model model) {
        ttCaNhanService.delete(id);
        FunctionTtCaNhanController.loadLaiTrang(model, true, ttCaNhanService);
        return "ttCaNhan/ttCaNhan";
    }
    //</editor-fold>
}
