package dft.domain.model;

import java.util.Date;

public class DM_THON_XOM {
    private long id;
    private String ma;
    private String ten;
    private String moTa;
    private String maTinh;
    private String maHuyen;
    private String maXa;
    private int trangThai;
    private Date ngayTao;
    private int nguoiTaoId;
    private Date ngaySua;
    private int nguoiSuaId;

    public DM_THON_XOM(){

    }

    public DM_THON_XOM(long id, String ma, String ten, String moTa, String maTinh, String maHuyen, String maXa, int trangThai, Date ngayTao, int nguoiTaoId, Date ngaySua, int nguoiSuaId) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.maTinh = maTinh;
        this.maHuyen = maHuyen;
        this.maXa = maXa;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.nguoiTaoId = nguoiTaoId;
        this.ngaySua = ngaySua;
        this.nguoiSuaId = nguoiSuaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getMaHuyen() {
        return maHuyen;
    }

    public void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public String getMaXa() {
        return maXa;
    }

    public void setMaXa(String maXa) {
        this.maXa = maXa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getNguoiTaoId() {
        return nguoiTaoId;
    }

    public void setNguoiTaoId(int nguoiTaoId) {
        this.nguoiTaoId = nguoiTaoId;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getNguoiSuaId() {
        return nguoiSuaId;
    }

    public void setNguoiSuaId(int nguoiSuaId) {
        this.nguoiSuaId = nguoiSuaId;
    }
}
