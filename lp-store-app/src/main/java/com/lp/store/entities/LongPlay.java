package com.lp.store.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "lp")
public class LongPlay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;


    @NotBlank(message = "author is mandatory")
    private String author;

    @NotBlank(message = "style is mandatory")
    private String style;

    private String releasedYear;

    private double price;

    public LongPlay() {}

    public LongPlay(String name, String style, String releasedYear, double price) {
        this.name = name;
        this.style = style;
        this.releasedYear = releasedYear;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    public String getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(String releasedYear) {
        this.releasedYear = releasedYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "LongPlay{id=" + id + ", name=" + name + ",author=" + author + ", style=" + style + ", year=" + releasedYear + ", price=" + price + '}';
    }
}