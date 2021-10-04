package com.demo.entities;

public class Product {
    
    // attributes

    private Integer id;
    private String prodName;
    private Double price;
    private Integer amount;

    // constructors

    public Product(Integer id, String prodName, Double price, Integer amount) {
        this.id = id;
        this.prodName = prodName;
        this.price = price;
        this.amount = amount;
    }

    public Product(Integer id, String prodName, Integer price, Integer amount) {
        this(id, prodName, Double.valueOf(price), amount);
    }

    public Product(String prodName, Double price, Integer amount) {
        this.prodName = prodName;
        this.price = price;
        this.amount = amount;
    }

    public Product(String prodName, Integer price, Integer amount) {
        this(prodName, Double.valueOf(price), amount);
    }

    public Product() {

    }

    // getters and setters

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdName() {
        return this.prodName;
    }

    public void setPrice(Double price) {
        this.price = price >= 0 ? price : 0;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount >= 0 ? amount : 0;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", prodName=" + prodName + ", price=" + price + ", amount=" + amount + "]";
    }
}
