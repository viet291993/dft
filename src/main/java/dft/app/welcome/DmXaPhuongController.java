package dft.app.welcome;

import dft.domain.model.DmXaPhuong;
import dft.domain.service.DmXaPhuongService;
import dft.domain.service.TtCaNhanService.TtCaNhanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/dmxaphuong")
public class DmXaPhuongController {
    @Inject
    DmXaPhuongService dmXaPhuongService;

    @GetMapping(value = "")
    public String showAllDmXaPhuong(Model model) {
        model.addAttribute("listDmXaPhuong", dmXaPhuongService.findAll());
        return "dmxaphuong/dmxaphuong";
    }
}
