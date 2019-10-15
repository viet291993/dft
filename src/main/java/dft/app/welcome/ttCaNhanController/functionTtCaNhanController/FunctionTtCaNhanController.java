package dft.app.welcome.ttCaNhanController.functionTtCaNhanController;

import dft.domain.dto.ttCaNhanDTO.TtCaNhanDTO;
import dft.domain.model.TtCaNhan;
import dft.domain.service.TtCaNhanService.TtCaNhanService;
import org.springframework.beans.BeanUtils;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FunctionTtCaNhanController {
    //<editor-fold defaultstate="collapsed" desc="kiểm tra">
    // kiểm tra ngày tháng có tồn tại
    private static Date kiemTraNgayThangCoTonTai(TtCaNhanDTO ttCaNhanDTO, BindingResult br, Model model, TtCaNhanService ttCaNhanService) {
        try {
            // chuyển chuỗi có dạng dd-MM-yyyy thành date
            SimpleDateFormat formatToDate = new SimpleDateFormat("dd-MM-yyyy");
            formatToDate.setLenient(false);
            Date nsDate =  formatToDate.parse(ttCaNhanDTO.getNgaySinh());

            // không phải là 1 ngày trong quá khứ
            if (nsDate.after(new Date())) {
                br.rejectValue("ngaySinh", "ttCaNhanDTO", "Vui lòng nhập 1 ngày trong quá khứ");
                return null;
            }

            return nsDate;
        }
        catch (ParseException e) {
            // ngày không tồn tại
            br.rejectValue("ngaySinh", "ttCaNhanDTO", "Vui lòng nhập ngày tháng có tồn tại");
            return null;
        }
    }

    // check trùng mã y tế cá nhân
    private static boolean kiemTraTrungMaYTeCaNhan(TtCaNhanDTO ttCaNhanDTO, BindingResult br, Model model, TtCaNhanService ttCaNhanService) {
        int trungMaYTeCaNhan = ttCaNhanService.findOneByMaYTeCaNhan(ttCaNhanDTO.getMaYTeCaNhan());

        if (trungMaYTeCaNhan != 0 ) {
            br.rejectValue("maYTeCaNhan", "ttCaNhanDTO", "Trùng mã y tế cá nhân");
            return false;
        }

        return true;
    }

    // trả về ngày sinh nếu không có lỗi ở input ngày sinh và mã y tế các nhân khi bấm nút thêm hoặc nút sửa
    private static Date kiemTraNgaySinhVaMaYTeCaNhan(TtCaNhanDTO ttCaNhanDTO, BindingResult br, Model model, TtCaNhanService ttCaNhanService, boolean showDanhSach) {
        Date nsDate = kiemTraNgayThangCoTonTai(ttCaNhanDTO, br, model, ttCaNhanService);
        if (nsDate == null) {
            return null;
        }

        // nếu mà mã y tế không thay đổi j khi update thì không cần kiểm tra trùng
        if (showDanhSach) {
            String maYTeCaNhan = ttCaNhanService.findMaYTeCaNhanById(ttCaNhanDTO.getId());
            if (maYTeCaNhan.equals(ttCaNhanDTO.getMaYTeCaNhan())) {
                return nsDate;
            }
        }

        if (!kiemTraTrungMaYTeCaNhan(ttCaNhanDTO, br, model, ttCaNhanService)) {
            return null;
        }

        return nsDate;
    }

    // kiểm tra toàn bộ các input và trả về 1 tt cá nhân nếu các input được nhập đúng
    public static TtCaNhan kiemTra(TtCaNhanDTO ttCaNhanDTO, BindingResult br, Model model, TtCaNhanService ttCaNhanService, boolean showDanhSach) {
        if (br.hasErrors()) {
            return null;
        }

        // kiểm tra ngày sinh, mã y tế cá nhân và chuyển enrity thành dto
        TtCaNhan ttCaNhan = chuyenEntityThanhDTO(ttCaNhanDTO, br, model, ttCaNhanService, showDanhSach);
        if (ttCaNhan == null) {
            return null;
        }

        return ttCaNhan;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="hàm chuyển đổi">
    // chuyển tt cá nhân thành tt cá nhân dto
    private static TtCaNhan chuyenEntityThanhDTO(TtCaNhanDTO ttCaNhanDTO, BindingResult br, Model model, TtCaNhanService ttCaNhanService, boolean showDanhSach) {
        Date nsDate = kiemTraNgaySinhVaMaYTeCaNhan(ttCaNhanDTO, br, model, ttCaNhanService, showDanhSach);
        if (nsDate == null) {
            return null;
        }

        // chuyển date về dạng chuỗi theo dạng yyyyMMdd
        SimpleDateFormat formatToString = new SimpleDateFormat("yyyyMMdd");
        String nsString = formatToString.format(nsDate);

        // chuyển chuỗi có dạng yyyyMMdd về dạng Integer
        Integer nsInt = Integer.parseInt(nsString);

        //chuyển dto thành entity
        TtCaNhan ttCaNhan = new TtCaNhan();
        BeanUtils.copyProperties(ttCaNhanDTO, ttCaNhan, "ngaySinh");
        ttCaNhan.setHoTen(ttCaNhan.getHoTen().trim()); // bỏ ký tự trắng đầu, cuối chuỗi
        ttCaNhan.setNgaySinh(nsInt);

        return ttCaNhan;
    }

    // chuyển entity thành dto, chuyển list entity thành list dto
    private static List<TtCaNhanDTO> chuyenEntityThanhDTO(List<TtCaNhan> lstTtCaNhan) {
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
    public static String chuyenNgaySinhThanhString(Integer ngaySinhOld) {
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
    public static void loadLaiTrang(Model model, boolean xoaTrangForm, TtCaNhanService ttCaNhanService, boolean showDanhSach, TtCaNhanDTO ttCaNhanDTO) {
        // tạo 1 cái model attribute chứa ttCaNhan rỗng nếu không có lỗi
        if (xoaTrangForm) {
            model.addAttribute("ttCaNhanDTO", new TtCaNhanDTO());
        }

        // tạo 1 cái request attribute chứa danh sách tỉnh thành phố để đưa vào combobox
        model.addAttribute("lstDmTinhs", ttCaNhanService.findAllTinh());

        if (ttCaNhanDTO.getTtHuyen() != null) {
            // lấy mã tỉnh vì tỉnh 1-n huyện và nối vs nhau bằng mã chứ không phải id
            String maTinh = ttCaNhanService.findMaTinh((long) ttCaNhanDTO.getTtTinh().getId());

            // tạo 1 cái request attribute chứa danh sách quận huyện để đưa vào combobox
            model.addAttribute("lstDmQuanHuyens", ttCaNhanService.findAllQuanHuyen(maTinh));
        }

        if (ttCaNhanDTO.getTtXa() != null) {
            String maQuanHuyen = ttCaNhanService.findMaQuanHuyen((long) ttCaNhanDTO.getTtHuyen().getId());

            // tạo 1 cái request attribute chứa danh sách quận xã phường để đưa vào combobox
            model.addAttribute("lstDmXaPhuongs", ttCaNhanService.findAllXaPhuong(maQuanHuyen));
        }

        if (ttCaNhanDTO.getTtThonXom() != null) {
            // tạo 1 cái request attribute chứa danh sách thôn xóm để đưa vào combobox
            model.addAttribute("lstDmThonXoms", ttCaNhanService.findAllThonXom(String.valueOf(ttCaNhanDTO.getTtXa().getId())));
        }

        if (showDanhSach) {
            // tạo 1 cái request attribute chứa danh sách tt cá nhân để đưa về trang ttCaNhan.jsp
            System.out.println((long) ttCaNhanDTO.getTtThonXom().getId() + "alo alo");
            model.addAttribute("lstTtCaNhanDTOs", chuyenEntityThanhDTO(ttCaNhanService.findAllTtCaNhan((long) ttCaNhanDTO.getTtThonXom().getId(), 0)));
        }
    }
}
