package si.karniolus.gospodar.business.client;

/**
 * Created by alojz_000 on 27. 01. 2017.
 */
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
