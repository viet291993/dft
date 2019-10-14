package dft.app.welcome.ttCaNhanController;

import dft.domain.dto.ttCaNhanDTO.TtCaNhanDTO;
import dft.domain.model.*;
import dft.domain.service.TtCaNhanService.TtCaNhanService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import java.text.*;
import java.util.ArrayList;
import java.util.*;

@Controller
@RequestMapping("/ttCaNhan")
public class TtCaNhanController {
    @Inject
    TtCaNhanService ttCaNhanService;

    @GetMapping(value = "/")
    public String showAllTtCaNhan(Model model) {
        loadLaiTrang(model, false);

        return "ttCaNhan/ttCaNhan";
    }

    //<editor-fold defaultstate="collapsed" desc="thêm, sửa, xóa">
    @PostMapping(value = "/", params = "btnThem")
    public String them(@Validated @ModelAttribute("ttCaNhanDTO") TtCaNhanDTO ttCaNhanDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            loadLaiTrang(model, true);

            return "ttCaNhan/ttCaNhan";
        }

        try {
            // chuyển chuỗi có dạng dd-MM-yyyy thành date
            SimpleDateFormat formatToDate = new SimpleDateFormat("dd-MM-yyyy");
            formatToDate.setLenient(false);
            Date nsDate = formatToDate.parse(ttCaNhanDTO.getNgaySinh());

            // không phải là 1 ngày trong quá khứ
            if (nsDate.after(new Date())) {
                loadLaiTrang(model, true);
                br.rejectValue("ngaySinh", "ttCaNhanDTO", "Vui lòng nhập ngày tháng đã tồn tại");
                return "ttCaNhan/ttCaNhan";
            }

            int trungMaYTeCaNhan = ttCaNhanService.findOne(ttCaNhanDTO.getMaYTeCaNhan());

            if (trungMaYTeCaNhan != 0 ) {
                loadLaiTrang(model, true);
                br.rejectValue("maYTeCaNhan", "ttCaNhanDTO", "Trùng mã y tế cá nhân");
                return "ttCaNhan/ttCaNhan";
            }

            // chuyển date về dạng chuỗi theo dạng yyyyMMdd
            SimpleDateFormat formatToString = new SimpleDateFormat("yyyyMMdd");
            String nsString = formatToString.format(nsDate);

            // chuyển chuỗi có dạng yyyyMMdd về dạng Integer
            Integer nsInt = Integer.parseInt(nsString);

            //chuyển dto thành entity
            TtCaNhan ttCaNhan = new TtCaNhan();
            BeanUtils.copyProperties(ttCaNhanDTO, ttCaNhan, "ngaySinh");
            ttCaNhan.setNgaySinh(nsInt);

            // thêm 1 cá nhân vào csdl
            ttCaNhanService.insert(ttCaNhan);

            // load lại trang
            loadLaiTrang(model, false);
        }
        catch (ParseException e) {
            // ngày không tồn tại
            loadLaiTrang(model, true);
            br.rejectValue("ngaySinh", "ttCaNhanDTO", "Vui lòng nhập ngày tháng có tồn tại");
            return "ttCaNhan/ttCaNhan";
        }

        return "ttCaNhan/ttCaNhan";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="hàm chuyển đổi">
    // chuyển entity thành dto
    private List<TtCaNhanDTO> chuyenEntityThanhDTO(List<TtCaNhan> lstTtCaNhan) {
        List<TtCaNhanDTO> lstTtCaNhanDTOS = new ArrayList<>();

        for (TtCaNhan t : lstTtCaNhan) {
            // đưa dữ liệu vào đối tượng DTO
            TtCaNhanDTO ttCaNhanDTO = new TtCaNhanDTO();
            BeanUtils.copyProperties(t, ttCaNhanDTO, "ngaySinh");
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
    //</editor-fold>

    // load lại các combo box, bảng trên trang
    private void loadLaiTrang(Model model, boolean hasErrors) {
        // tạo 1 cái model attribute chứa ttCaNhan rỗng nếu không có lỗi
        if (!hasErrors) {
            model.addAttribute("ttCaNhanDTO", new TtCaNhanDTO());
        }

        // tạo 1 cái request attribute chứa danh sách tỉnh thành phố để đưa vào combobox
//        model.addAttribute("lstDmTinhs", ttCaNhanService.findAllTinh());

        // tạo 1 cái request attribute chứa danh sách quận huyện để đưa vào combobox
        model.addAttribute("lstDmQuanHuyens", ttCaNhanService.findAllQuanHuyen());

        // tạo 1 cái request attribute chứa danh sách thôn xóm để đưa vào combobox
//        model.addAttribute("lstDmThonXoms", ttCaNhanService.findAllThonXom());

        // tạo 1 cái request attribute chứa danh sách tt cá nhân để đưa về trang ttCaNhan.jsp
        model.addAttribute("lstTtCaNhanDTOs", chuyenEntityThanhDTO(ttCaNhanService.findAllTtCaNhan()));
    }
}
