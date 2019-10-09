package dft.app.welcome.ttCaNhanController;

import dft.domain.dto.ttCaNhanDTO.TtCaNhanDTO;
import dft.domain.model.TtCaNhan;
import dft.domain.service.TtCaNhanService.TtCaNhanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.ArrayList;
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
            ttCaNhanDTO.setId(t.getId());
            ttCaNhanDTO.setMaYTeCaNhan(t.getMaYTeCaNhan());
            ttCaNhanDTO.setHoTen(t.getHoTen());
            ttCaNhanDTO.setGioiTinhID(t.getGioiTinh().getId());
            ttCaNhanDTO.setNgaySinh(chuyenNgaySinhThanhString(t.getNgaySinh()));

            // add vào list DTO
            lstTtCaNhanDTOS.add(ttCaNhanDTO);
        }

        return lstTtCaNhanDTOS;
    }

    // chuyển ngày sinh từ Integer thành string
    private String chuyenNgaySinhThanhString(Integer ngaySinhOld) {
        // cắt ngày sinh thành năm, tháng, ngày
        StringBuilder ngaySinh = new StringBuilder(String.valueOf(ngaySinhOld));
        String nam = ngaySinh.substring(0, 4);
        String thang = ngaySinh.substring(4, 6);
        String ngay = ngaySinh.substring(6, 8);

        // nối thành chuỗi dd-MM-yyyy
        StringBuilder ngaySinhNew = new StringBuilder(ngay);
        ngaySinhNew.append("-");
        ngaySinhNew.append(thang);
        ngaySinhNew.append("-");
        ngaySinhNew.append(nam);

        return ngaySinhNew.toString();
    }
}
