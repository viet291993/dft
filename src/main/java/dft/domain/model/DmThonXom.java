package dft.domain.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Danh mục thôn xóm
 */
public class DmThonXom implements Serializable {
    private int id;
    private String maThon;
    private String tenThon;
    private String moTaThon;
    private String maTinh;
    private String maHuyen;
    private String maXa;
    private int trangThai;

    public DmThonXom() {
    }

    public DmThonXom(int id, String maThon, String tenThon, String moTaThon, String maTinh, String maHuyen, String maXa, int trangThai) {
        this.id = id;
        this.maThon = maThon;
        this.tenThon = tenThon;
        this.moTaThon = moTaThon;
        this.maTinh = maTinh;
        this.maHuyen = maHuyen;
        this.maXa = maXa;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaThon() {
        return maThon;
    }

    public void setMaThon(String maThon) {
        this.maThon = maThon;
    }

    public String getTenThon() {
        return tenThon;
    }

    public void setTenThon(String tenThon) {
        this.tenThon = tenThon;
    }

    public String getMoTaThon() {
        return moTaThon;
    }

    public void setMoTaThon(String moTaThon) {
        this.moTaThon = moTaThon;
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

}
