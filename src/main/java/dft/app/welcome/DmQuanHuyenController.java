package dft.app.welcome;

import dft.domain.model.DmQuanHuyen;
import dft.domain.model.DmTinhTP;
import dft.domain.service.DmQuanHuyenService;
import dft.domain.service.DmTinhTPService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;


/**
 *Controler Quan huyện
 */
@Controller
@RequestMapping("/QuanHuyen")
public class DmQuanHuyenController {

    @Inject DmQuanHuyenService dmQuanHuyenService;

    @Inject
    DmTinhTPService dmTinhTPService;

    // Lấy danh sách Tỉnh lên Seclect
    @ModelAttribute("litsTinhTP_Selects")
    public List<DmTinhTP> listDmTinhTP(){
        return dmTinhTPService.findAll();
    }

    /**
     * Hiển thị danh sách Quận huyện lên view
     */
    @GetMapping(value = "")
    public String list(Model model) {
        List<DmQuanHuyen> listDmQuanHuyen = dmQuanHuyenService.findAll();
        model.addAttribute("listDmQuanHuyen", listDmQuanHuyen);
        return "DmQuanHuyen/DmQuanHuyenList";
    }

    /**
     * Hiển thị form thêm Quận huyện lên view
     */
    @GetMapping(value = "/Them")
    public String createView(@ModelAttribute("DmQuanHuyen") DmQuanHuyen dmQuanHuyen) {
        return "DmQuanHuyen/DmQuanHuyenInsert";
    }

    /**
     * Gửi thông tin Quận Huyện lên Server để insert vào DB
     * @param dmQuanHuyen
     *
     */
    @PostMapping(value = "/Them")
    public String create(Model model, @ModelAttribute("DmQuanHuyen") DmQuanHuyen dmQuanHuyen) {
        if(dmQuanHuyenService.create(dmQuanHuyen)){
            System.out.println("Thêm Quận Huyện thành công");
        }else{
            System.out.println("Thêm Quận Huyện thất bại");
        };
        return "DmQuanHuyen/DmQuanHuyenInsert";
    }

    /**
     * Hiển thị form sửa Quận huyện lên view
     */
    @GetMapping(value = "/Sua/{id}")
    public String editView(Model model,@ModelAttribute("DmQuanHuyen") DmQuanHuyen dmQuanHuyen, @PathVariable("id") int id) {
        model.addAttribute("DmQuanHuyen",dmQuanHuyenService.findOne(id));
        return "DmQuanHuyen/DmQuanHuyenUpdate";
    }

    /**
     * Gửi thông tin Quận Huyện lên Server để update vào DB
     * @param dmQuanHuyen
     *
     */
    @PostMapping(value = "/Sua")
    public String edit(Model model, @ModelAttribute("DmQuanHuyen") DmQuanHuyen dmQuanHuyen) {
        if(dmQuanHuyenService.update(dmQuanHuyen)){
            System.out.println("Sửa Quận Huyện thành công");
        }else{
            System.out.println("Sửa Quận Huyện thất bại");
        };
        return "DmQuanHuyen/DmQuanHuyenUpdate";
    }


}
