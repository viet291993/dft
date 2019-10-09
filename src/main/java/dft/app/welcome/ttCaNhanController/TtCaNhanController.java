package dft.app.welcome.ttCaNhanController;

import dft.domain.service.TtCaNhanService.TtCaNhanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.inject.Inject;

@Controller
public class TtCaNhanController {
    @Inject
    TtCaNhanService ttCaNhanService;

    @GetMapping(value = "/")
    public String showAllTtCaNhan(Model model) {
        model.addAttribute("lstTtCaNhan", ttCaNhanService.findAllTtCaNhan());
        return "";
    }
}
