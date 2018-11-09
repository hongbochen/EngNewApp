package laoc.site.laoceng.entity;

public class Article {

    private long artid;
    private String artName;
    private String artBrief;
    private String artImg;

    public Article(long artid, String artName, String artBrief, String artImg) {
        this.artid = artid;
        this.artName = artName;
        this.artBrief = artBrief;
        this.artImg = artImg;
    }

    public long getArtid() {
        return artid;
    }

    public void setArtid(long artid) {
        this.artid = artid;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public String getArtBrief() {
        return artBrief;
    }

    public void setArtBrief(String artBrief) {
        this.artBrief = artBrief;
    }

    public String getArtImg() {
        return artImg;
    }

    public void setArtImg(String artImg) {
        this.artImg = artImg;
    }
}
