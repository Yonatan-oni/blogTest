package com.yonileulseged.einc.entity;

import javax.persistence.*;

@Entity
@Table(name="blogs")
public class Blog {
//    blogId = id
//    link= new
//    title=firstname
//    content=lastname
//    path=email


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bolgId;
    @Column(name = "path", nullable = false)
    private String path;
    @Column(name = "link", nullable = false)
    private String link;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;

    public Blog(){}
    public Blog(String path, String link, String title, String content) {
        super();
        this.path = path;
        this.link = link;
        this.title = title;
        this.content = content;
    }

    public Integer getBolgId() {
        return bolgId;
    }

    public void setBolgId(Integer bolgId) {
        this.bolgId = bolgId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
}
