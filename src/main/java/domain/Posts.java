package domain;

import repositories.UserRepository;

import java.util.Date;

public class Posts {
    private int post_id;
    private String title;
    private String content;
    private Date pub_date;
    private int author_id;

    public Posts(int post_id, String title, String content, Date pub_date, int author_id) {
        this.post_id = post_id;
        this.title = title;
        this.content = content;
        this.pub_date = pub_date;
        this.author_id = author_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
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

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
}
