package dft.app.welcome;

import dft.domain.model.DmTinhTP;
import dft.domain.service.DmTinhTPService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/tinhTP")
public class DmTinhTPController {
    @Inject
    DmTinhTPService dmTinhTPService;

    @RequestMapping("")
    public String getAllTinh(Model model){
        List<DmTinhTP> lstTinh = dmTinhTPService.findAll();
        model.addAttribute("lstTinh" , lstTinh);
        return "DmTinhTP/DmTinhTPList";
    }

    @GetMapping("/them")
    public String themTinhTp(Model model){
        DmTinhTP tinh = new DmTinhTP();
        model.addAttribute("tinh" ,tinh);
        return "DmTinhTP/DmTinhTPAdd";
    }

    @PostMapping("/them")
    public String themTinhTp(@ModelAttribute("tinh") DmTinhTP tinh){
        try{
            dmTinhTPService.create(tinh);
            return "redirect:DmTinhTP/DmTinhTPList";
        }catch (Exception e){
            System.out.println("Loi!!!!!!");
            return "redirect:DmTinhTP/DmTinhTPAdd";
        }
    }

    @GetMapping("/sua/{id}")
    public String suaTinhTp(Model model, @PathVariable("id") int id){
        DmTinhTP tinh = dmTinhTPService.findOne(id);
        model.addAttribute("tinh" ,tinh);
        return "DmTinhTP/DmTinhTPUpdate";
    }

    @PostMapping("/sua")
    public String suaTinhTp(@ModelAttribute("tinh") DmTinhTP tinh){
        try{
            DmTinhTP tinh1 = dmTinhTPService.findOne(tinh.getId());
            String ma = tinh1.getMa();
            int maTam = Integer.parseInt(ma);
            ma = Integer.toString(maTam);
            dmTinhTPService.update(tinh, ma);
            return "redirect:DmTinhTP/DmTinhTPList";
        }catch (Exception e){
            System.out.println("Loi!!!!!!");
            return "redirect:DmTinhTP/DmTinhTPUpdate";
        }
    }

    @RequestMapping("/xoa/{id}")
    public String deleteTinh(Model model,@PathVariable("id") int id){
        try{
            dmTinhTPService.deleteById(id);
            model.addAttribute("notifi", "Xóa thành công");
        }catch (Exception e){
            model.addAttribute("notifi", "Xóa thất bại");
        }
        return "redirect:DmTinhTP/DmTinhTPList";
    }
}
