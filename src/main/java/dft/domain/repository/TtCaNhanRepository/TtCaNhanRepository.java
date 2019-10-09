package dft.domain.repository.TtCaNhanRepository;

import dft.domain.model.DMGioiTinh;
import dft.domain.model.TtCaNhan;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TtCaNhanRepository {
    @Select("select ho_ten, " +
            "gioi_tinh_id, " +
            "ngay_sinh from tt_ca_nhan where rownum < 20")
    @Results(value = {
            @Result(property = "hoTen", column = "ho_ten"),
            @Result(property = "gioiTinh", javaType = DMGioiTinh.class, column = "gioi_tinh_id", one = @One(select = "findAllGioiTinh"))
    })
    public List<TtCaNhan> findAllTtCaNhan();

    @Select("select id, ten from dm_gioi_tinh where id = #{id}")
    public DMGioiTinh findAllGioiTinh();
}
