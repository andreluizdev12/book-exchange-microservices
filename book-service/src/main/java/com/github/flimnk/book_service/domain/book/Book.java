package com.github.flimnk.book_service.domain.book;



import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 180)
    private String author;

    @Column(nullable = false, length = 250)
    private String title;

    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;

    @Column(nullable = false)
    private Double price;



    public Book(){}

    public Book(Long id, String author, String title,
                Date launchDate, Double price,
                String currency, String environment) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.launchDate = launchDate;
        this.price = price;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }




    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getId(), book.getId()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getLaunchDate(), book.getLaunchDate()) && Objects.equals(getPrice(), book.getPrice() );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getTitle(), getLaunchDate(), getPrice());
    }
}