package dft.domain.dto.ttCaNhanDTO;

public class TtCaNhanDTO {
    private Long id;
    private String maYTeCaNhan;
    private String hoTen;
    private long gioiTinhID;
    private String ngaySinh;

    //<editor-fold defaultstate="collapsed" desc="get và set">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaYTeCaNhan() {
        return maYTeCaNhan;
    }

    public void setMaYTeCaNhan(String maYTeCaNhan) {
        this.maYTeCaNhan = maYTeCaNhan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public long getGioiTinhID() {
        return gioiTinhID;
    }

    public void setGioiTinhID(long gioiTinhID) {
        this.gioiTinhID = gioiTinhID;
    }

    //</editor-fold>

}
