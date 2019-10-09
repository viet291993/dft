package dft.domain.repository.TtCaNhanRepository;

import dft.domain.model.DMGioiTinh;
import dft.domain.model.TtCaNhan;
import org.apache.ibatis.annotations.*;

public interface TtCaNhanRepository {
//    @Select("select HO_TEN,\n" +
//            "    NGAY_SINH,\n" +
//            "    (select TEN from DM_GIOI_TINH where DM_GIOI_TINH.ID = TT_CA_NHAN.GIOI_TINH_ID),\n" +
//            "    (select TEN from DM_TINH_TP where DM_TINH_TP.ID = TT_CA_NHAN.TT_TINH_ID),\n" +
//            "    (select TEN from DM_QUAN_HUYEN where DM_QUAN_HUYEN.ID = TT_CA_NHAN.TT_TINH_ID),\n" +
//            "    (select TEN from DM_XA_PHUONG where DM_XA_PHUONG.ID = TT_CA_NHAN.TT_TINH_ID),\n" +
//            "    (select TEN from DM_THON_XOM where DM_THON_XOM.ID = TT_CA_NHAN.TT_TINH_ID),\n" +
//            "    TRANG_THAI\n" +
//            "from TT_CA_NHAN;")

    @Results(value = {
            @Result(property = "hoTen", column = "ho_ten"),
            @Result(property = "gioiTinh", javaType = DMGioiTinh.class, column = "gioi_tinh_id", one = @One(select = "findAllGioiTinh"))
    })
    public TtCaNhan findAllTtCaNhan();

    @Select("select ten from dm_gioi_tinh where id = #{id}")
    public DMGioiTinh findAllGioiTinh();
}
