package dft.app.welcome.ttCaNhanController;

import dft.app.welcome.ttCaNhanController.functionTtCaNhanController.FunctionTtCaNhanController;
import dft.domain.dto.ttCaNhanDTO.TtCaNhanDTO;
import dft.domain.model.TtCaNhan;
import dft.domain.service.TtCaNhanService.TtCaNhanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@RequestMapping("/ttCaNhan")
public class TtCaNhanSuaController {
    @Inject
    TtCaNhanService ttCaNhanService;

    @PostMapping(value = "/", params = "btnHuy")
    public String huy(Model model) {
        FunctionTtCaNhanController.loadLaiTrang(model, false, ttCaNhanService);
        return "ttCaNhan/ttCaNhan";
    }

    @PostMapping(value = "/", params = "btnCapNhat")
    public String capNhat(@Validated @ModelAttribute("ttCaNhanDTO") TtCaNhanDTO ttCaNhanDTO, BindingResult br, Model model) {
        TtCaNhan ttCaNhan = FunctionTtCaNhanController.kiemTra(ttCaNhanDTO, br, model, ttCaNhanService, true);
        if (ttCaNhan == null) {
            FunctionTtCaNhanController.loadLaiTrang(model, true, ttCaNhanService);
            return "ttCaNhan/ttCaNhan";
        }

        // sửa 1 cá nhân vào csdl và load lại các combobox, bảng
        ttCaNhanService.update(ttCaNhan);
        FunctionTtCaNhanController.loadLaiTrang(model, false, ttCaNhanService);
        return "ttCaNhan/ttCaNhan";
    }
}
