package app.tdc.edu.com.tuyendung;

/**
 * Created by Việt Hải on 4/11/2017.
 */

public class ThuocTinh {
    private String tieude, congty, diadiem,luong, ngaydang,link ;

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ThuocTinh(String tieude1, String s, String tieude, String congty, String diadiem, String luong) {
        this.tieude = tieude;
        this.congty = congty;
        this.diadiem = diadiem;
        this.luong = luong;
        this.ngaydang = ngaydang;
        this.link = link;


    }



    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getCongty() {
        return congty;
    }

    public void setCongty(String congty) {
        this.congty = congty;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(String ngaydang) {
        this.ngaydang = ngaydang;
    }

    public String getStrLink() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "ThuocTinh{" +
                "tieude='" + tieude + '\'' +
                ", congty='" + congty + '\'' +
                ", diadiem='" + diadiem + '\'' +
                ", luong='" + luong + '\'' +
                ", ngaydang='" + ngaydang + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

//    public ThuocTinh get(int position) {
//        return null;
//    }
}
