package dft.app.welcome.ttCaNhanController;

import dft.domain.dto.ttCaNhanDTO.TtCaNhanDTO;
import dft.domain.model.TtCaNhan;
import dft.domain.service.TtCaNhanService.TtCaNhanService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/ttCaNhan")
public class TtCaNhanController {
    @Inject
    TtCaNhanService ttCaNhanService;

    @GetMapping(value = "/")
    public String showAllTtCaNhan(Model model) {
        // tạo 1 cái request attribute để đưa về trang ttCaNhan.jsp
        model.addAttribute("lstTtCaNhanDTOs", chuyenEntityThanhDTO(ttCaNhanService.findAllTtCaNhan()));
        return "ttCaNhan/ttCaNhan";
    }

    // chuyển entity thành dto
    private List<TtCaNhanDTO> chuyenEntityThanhDTO(List<TtCaNhan> lstTtCaNhan) {
        List<TtCaNhanDTO> lstTtCaNhanDTOS = new ArrayList<>();

        for (TtCaNhan t : lstTtCaNhan) {
            // đưa dữ liệu vào đối tượng DTO
            TtCaNhanDTO ttCaNhanDTO = new TtCaNhanDTO();
            BeanUtils.copyProperties(t, ttCaNhanDTO, "ngaySinh");
            ttCaNhanDTO.setGioiTinhID(t.getGioiTinh().getId());
            ttCaNhanDTO.setNgaySinh(chuyenNgaySinhThanhString(t.getNgaySinh()));

            // add vào list DTO
            lstTtCaNhanDTOS.add(ttCaNhanDTO);
        }

        return lstTtCaNhanDTOS;
    }

    // chuyển ngày sinh từ Integer thành string
    private String chuyenNgaySinhThanhString(Integer ngaySinhOld) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date ngaySinhNew = format.parse(ngaySinhOld.toString());
            SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");

            return format2.format(ngaySinhNew);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
