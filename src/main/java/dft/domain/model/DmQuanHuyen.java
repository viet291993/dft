package dft.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * A DmQuanHuyen.
 */
public class DmQuanHuyen implements Serializable {

    private int id;
    private String ma;
    private String ten;
    private String moTa;
    private String maTinh;
    private String cap;
    private int trangThai;
    private Timestamp ngayTao;
    private int nguoiTaoId;
    private Timestamp ngaySua;
    private int nguoiSuaId;

    public DmQuanHuyen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getNguoiTaoId() {
        return nguoiTaoId;
    }

    public void setNguoiTaoId(int nguoiTaoId) {
        this.nguoiTaoId = nguoiTaoId;
    }

    public Timestamp getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Timestamp ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getNguoiSuaId() {
        return nguoiSuaId;
    }

    public void setNguoiSuaId(int nguoiSuaId) {
        this.nguoiSuaId = nguoiSuaId;
    }

    @Override
    public String toString() {
        return "DmQuanHuyen{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", moTa='" + moTa + '\'' +
                ", maTinh='" + maTinh + '\'' +
                ", cap='" + cap + '\'' +
                ", trangThai=" + trangThai +
                ", ngayTao=" + ngayTao +
                ", nguoiTaoId=" + nguoiTaoId +
                ", ngaySua=" + ngaySua +
                ", nguoiSuaId=" + nguoiSuaId +
                '}';
    }
}
