package model;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Deck implements Serializable {
    private int id;
    private ImageView image;
    private String code;
    private double size;
    private String name;
    private String brand;
    private double price;
    private String color;

    public Deck() {
    }

    public Deck(int id, ImageView image, String code, double size, String name, String brand, double price, String color) {
        this.id = id;
        this.image = image;
        this.code = code;
        this.size = size;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        image.setFitWidth(70);
        image.setFitHeight(70);
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", image=" + image +
                ", code='" + code + '\'' +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
