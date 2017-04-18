package app.tdc.edu.com.tuyendung.Object;

/**
 * Created by Việt Hải on 4/11/2017.
 */

public class Link {
    String  Link;

    public Link(String link) {
        super();
        Link = link;
    }

    @Override
    public String toString() {
        return   Link ;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public void add(Link link2) {
        // TODO Auto-generated method stub

    }

    public String size() {
        // TODO Auto-generated method stub
        return null;
    }

}
