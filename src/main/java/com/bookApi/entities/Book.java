package com.bookApi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="bookApi")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Auther author;

    public Book() {
    }

    public Book(int id, String title, Auther author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Auther getAuthor() {
        return author;
    }

    public void setAuthor(Auther author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
