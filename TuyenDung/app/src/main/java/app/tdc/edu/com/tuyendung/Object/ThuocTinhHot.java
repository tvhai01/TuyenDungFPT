package app.tdc.edu.com.tuyendung.Object;

/**
 * Created by Việt Hải on 4/11/2017.
 */

public class ThuocTinhHot {
    private String tieude, congty ,link ;

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



    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ThuocTinh{" +
                "tieude='" + tieude + '\'' +
                ", congty='" + congty + '\'' +
                '}';
    }
    public ThuocTinhHot(String tieude, String congty, String link) {
        this.tieude = tieude;
        this.congty = congty;
        this.link = link;
    }

//    public ThuocTinh get(int position) {
//        return null;
//    }
}
