package com.codegym.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String content;

    @ManyToOne
    @JoinColumn(name = "catagory_id")
    private Catagory catagory;

    public Blog() {
    }

    public Blog(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public Catagory getCatagory() {
        return (catagory == null) ? new Catagory() : catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog[id= " + id + ", author = " + author + ", content = " + content;
    }
}