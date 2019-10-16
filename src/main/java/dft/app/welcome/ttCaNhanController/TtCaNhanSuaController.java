package dft.app.welcome.ttCaNhanController;

import dft.app.welcome.ttCaNhanController.functionTtCaNhanController.FunctionTtCaNhanController;
import dft.domain.dto.ttCaNhanDTO.TtCaNhanDTO;
import dft.domain.model.DmQuanHuyen;
import dft.domain.model.DmXaPhuong;
import dft.domain.model.TtCaNhan;
import dft.domain.service.TtCaNhanService.TtCaNhanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/ttCaNhan")
public class TtCaNhanSuaController {
    @Inject
    TtCaNhanService ttCaNhanService;

    @PostMapping(value = "/", params = "btnHuy")
    public String huy(Model model) {
        FunctionTtCaNhanController.loadLaiTrang(model, false, ttCaNhanService, false);
        return "ttCaNhan/ttCaNhan";
    }

    @PostMapping(value = "/", params = "btnCapNhat")
    public String capNhat(@Validated @ModelAttribute("ttCaNhanSuaDTO") TtCaNhanDTO ttCaNhanDTO, BindingResult br, Model model) {
        // validate
        TtCaNhan ttCaNhan = FunctionTtCaNhanController.kiemTra(ttCaNhanDTO, br, model, ttCaNhanService, true);
        if (ttCaNhan == null) {
            FunctionTtCaNhanController.loadLaiTrang(model, true, ttCaNhanService, true);
            return "ttCaNhan/ttCaNhanSua";
        }

        // sửa 1 cá nhân vào csdl và load lại các combobox, bảng
        ttCaNhanService.update(ttCaNhan);
        FunctionTtCaNhanController.loadLaiTrang(model, false, ttCaNhanService, false);
        return "ttCaNhan/ttCaNhan";
    }
}
