package dft.app.welcome;

import dft.domain.model.DmQuanHuyen;
import dft.domain.model.DmThonXom;
import dft.domain.model.DmXaPhuong;
import dft.domain.service.DmQuanHuyenService;
import dft.domain.service.DmThonXomService;
import dft.domain.service.DmXaPhuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dm-thonxom/")
public class DmThonXomController {
    @Autowired
    private DmXaPhuongService dmXaPhuongService;

    @Autowired
    private DmQuanHuyenService dmQuanHuyenService;

    @Autowired
    private DmThonXomService dmThonXomService;

    // Lây danh sach tinh, TP)
    // Lây danh sach huyen, quan
    @ModelAttribute("dmQuanHuyen_List")
    public List<DmQuanHuyen> danhSachQuanHuyen() {
        return dmQuanHuyenService.findAll();
    }

    // Lay danh sach xa, phuong
    @ModelAttribute("dmXaPhuong_List")
    public List<DmXaPhuong> danhSachXaPhuong() {
        return dmXaPhuongService.findAll();
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String createDmThonXom(Model model) {
        model.addAttribute("DmThonXoms", dmThonXomService.findAll());
        return "DmThonXom/DmThonXomList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createThonXomForm() {
        return "DmThonXom/DmThonXomCreate";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createThonXom(@ModelAttribute("dmThonXom") DmThonXom dmThonXom, Model model) {
        dmThonXomService.create(dmThonXom);
        model.addAttribute("message", "Thêm Thôn, Xóm thành công");
        return "DmThonXom/DmThonXomCreate";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteDmThonXomById(@PathVariable("id") int dmThonXomId, Model model) {
        dmThonXomService.deleteById(dmThonXomId);
        return "redirect:/dm-thonxom/list";
    }

    @RequestMapping(value = "edit/{id}")
    public String editDmThonXomById(@PathVariable("id") int dmThonXomId, Model model) {
        model.addAttribute("dmThonXom", dmThonXomService.findById(dmThonXomId));
        return "DmThonXom/DmThonXomEdit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("dmThonXom") DmThonXom dmThonXom, Model model) {
        dmThonXomService.update(dmThonXom);
        return "redirect:/dm-thonxom/list";
    }
}
