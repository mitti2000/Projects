package de.galileo.scouttools.app;

/**
 * Created by studio on 05.06.2014. Kommentar
 */
public class ScoutLog {
    private String title;
    private String content;
    private long id;
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ScoutLog(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}
