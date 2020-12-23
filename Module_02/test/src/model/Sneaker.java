package model;

import javafx.beans.property.*;

public class Sneaker {
    private SimpleLongProperty barcode;
    private SimpleStringProperty brand;
    private SimpleStringProperty name;
    private SimpleDoubleProperty size;
    private SimpleIntegerProperty price;
    private SimpleIntegerProperty stock;

    public Sneaker() {
    }

    public Sneaker(long barcode, String brand, String name, double size, int price, int stock) {
        this.barcode = new SimpleLongProperty(barcode);
        this.brand = new SimpleStringProperty(brand);
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleDoubleProperty(size);
        this.price = new SimpleIntegerProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
    }

    public long getBarcode() {
        return barcode.get();
    }

    public void setBarcode(long barcode) {
        this.barcode = new SimpleLongProperty(barcode);
    }

    public String getBrand() {
        return brand.get();
    }

    public void setBrand(String brand) {
        this.brand = new SimpleStringProperty(brand);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public double getSize() {
        return size.get();
    }

    public void setSize(double size) {
        this.size = new SimpleDoubleProperty(size);
    }

    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        this.price = new SimpleIntegerProperty(price);
    }

    public int getStock() {
        return stock.get();
    }

    public void setStock(int stock) {
        this.stock = new SimpleIntegerProperty(stock);
    }
}
