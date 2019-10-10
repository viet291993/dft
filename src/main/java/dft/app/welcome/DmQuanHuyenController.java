package dft.app.welcome;

import dft.domain.model.DmQuanHuyen;
import dft.domain.service.DmQuanHuyenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 */
@Controller
@RequestMapping("/QuanHuyen")
public class DmQuanHuyenController {

    @Inject DmQuanHuyenService dmQuanHuyenService;

    /**
     *
     */
    @GetMapping(value = "")
    public String list(Model model) {
        List<DmQuanHuyen> listDmQuanHuyen = dmQuanHuyenService.getAll();
        model.addAttribute("listDmQuanHuyen", listDmQuanHuyen);
        return "welcome/home";
    }

}
