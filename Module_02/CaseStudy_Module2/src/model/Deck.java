package model;

public class Deck {
    private int id;
    private double size;
    private String name;
    private String brand;
    private double price;
    private String color;

    public Deck() {
    }

    public Deck(int id, double size, String name, String brand, double price, String color) {
        this.id = id;
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
}
