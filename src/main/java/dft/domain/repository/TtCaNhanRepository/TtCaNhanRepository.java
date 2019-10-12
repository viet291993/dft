package dft.domain.repository.TtCaNhanRepository;

import dft.domain.model.DMGioiTinh;
import dft.domain.model.DmQuanHuyen;
import dft.domain.model.TtCaNhan;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TtCaNhanRepository {
    @Select("select ho_ten, " +
            "gioi_tinh_id, " +
            "ngay_sinh from tt_ca_nhan where rownum < 5")
    @Results(value = {
            @Result(property = "hoTen", column = "ho_ten"),
            @Result(property = "gioiTinh", javaType = DMGioiTinh.class, column = "gioi_tinh_id", one = @One(select = "findAllGioiTinh"))
    })
    public List<TtCaNhan> findAllTtCaNhan();

    @Select("select id, ten from dm_gioi_tinh where id = #{id}")
    public DMGioiTinh findAllGioiTinh();

    @Select("select count(*) from TT_CA_NHAN where MA_Y_TE_CA_NHAN = #{maYTeCaNhan}")
    public int findOneByMaYTeCaNhan(String maYTeCaNhan);

    @Select("select ma_y_te_ca_nhan from tt_ca_nhan where id = #{id}")
    public String findMaYTeCaNhanById(Long id);

    @Select("select ho_ten, " +
            "gioi_tinh_id, " +
            "ngay_sinh, " +
            "TT_TINH_ID, " +
            "TT_HUYEN_ID, " +
            "TT_XA_ID, " +
            "TT_THON_XOM_ID from tt_ca_nhan where id = #{id}")
    public TtCaNhan findOneById(Long id);

    //<editor-fold defaultstate="collapsed" desc="lấy ra danh mục tỉnh, huyện, xã, thôn">
    @Select("select * from DM_TINH_TP")
    public List<DmQuanHuyen> findAllTinh();

    @Select("select * from DM_QUAN_HUYEN where rownum <= 5")
    public List<DmQuanHuyen> findAllQuanHuyen();

    @Select("select * from DM_XA_PHUONG")
    public List<DmQuanHuyen> findAllXaPhuong();

    @Select("select * from DM_THON_XOM")
    public List<DmQuanHuyen> findAllThonXom();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="thêm, sửa xóa">
    @Insert("insert into TT_CA_NHAN(" +
                "id, " +
                "HO_TEN, " +
                "MA_Y_TE_CA_NHAN, " +
                "NGAY_SINH, " +
                "GIOI_TINH_ID, " +
                "TT_HUYEN_ID)\n" +
            "values (" +
                "HIBERNATE_SEQUENCE.nextval, " +
                "#{hoTen}, " +
                "#{maYTeCaNhan}, " +
                "#{ngaySinh}, " +
                "#{gioiTinh.id}, " +
                "#{ttHuyen.id})"
    )
    public void insert(TtCaNhan ttCaNhan);

    @Update("update TT_CA_NHAN set " +
                "HO_TEN = #{hoTen}, " +
                "MA_Y_TE_CA_NHAN = #{maYTeCaNhan}, " +
                "NGAY_SINH = #{ngaySinh}, " +
                "GIOI_TINH_ID = #{gioiTinh.id}, " +
                "TT_HUYEN_ID = #{ttHuyen.id}\n" +
            "where ID = #{id}")
    public void update(TtCaNhan ttCaNhan);

    @Delete("delete from tt_ca_nhan where id = #{id}")
    public void delete(Long id);
    //</editor-fold>

}
