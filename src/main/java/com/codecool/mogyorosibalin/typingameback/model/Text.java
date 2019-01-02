package com.codecool.mogyorosibalin.typingameback.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Product product;
    @Type(type = "text")
    private String text;

    public Text() { }

    public Text(Product product, String text) {
        this.product = product;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
