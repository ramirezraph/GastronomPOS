package common;

import javax.swing.*;

public class Product {
    private String code;
    private String name;
    private String category;
    private double price;
    private String availability;
    private ImageIcon image;

    public Product(String code, String name, String category, double price, String availability) {
        this(code,name,category,price,availability,new ImageIcon(".\\src\\resources\\placeholder_100.jpg"));

    }

    public Product(String code, String name, String category, double price, String availability, ImageIcon image) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.price = price;
        this.availability = availability;
        this.image = image;
    }

    public void editInformation(String name, String category, double price, String availability, ImageIcon image){
        this.name = name;
        this.category = category;
        this.price = price;
        this.availability = availability;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
