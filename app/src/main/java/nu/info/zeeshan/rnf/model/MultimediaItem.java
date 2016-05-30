package nu.info.zeeshan.rnf.model;

/**
 * model required by NYTimes Item, as the api return a array of multimedia items within a item
 * Created by Zeeshan Khan on 5/14/2016.
 */
public class MultimediaItem {
    public interface TYPE {
        String THUMB = "Standard Thumbnail";
        String THUMB_LARGE = "thumbLarge";
        String NORMAL = "Normal";
        String MEDUIM = "mediumThreeByTwo210";
        String LARGE = "superJumbo";
    }

    String url;
    String format;
    int height;
    int width;
    String type;
    String subtype;
    String caption;
    String copyright;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
