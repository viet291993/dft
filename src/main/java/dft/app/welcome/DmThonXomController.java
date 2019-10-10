package dft.app.welcome;

import dft.domain.model.DmThonXom;
import dft.domain.service.DmThonXomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dm-thonxom/")
public class DmThonXomController {
    @Autowired
    private DmThonXomService dmThonXomService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String createDmThonXom(Model model){
        model.addAttribute("DmThonXoms", dmThonXomService.findAll());
        return "DmThonXom/DmThonXomList";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteDmThonXomById(@PathVariable("id")int dmThonXomId,Model model){
        dmThonXomService.deleteById(dmThonXomId);
        return  "redirect:/dm-thonxom/list";
    }
}
