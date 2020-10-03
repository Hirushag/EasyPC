package com.example.easypc;

public class PC_MODEL {
    private String id,part,brand,model,price,imageID;

    public PC_MODEL(String id, String part, String brand, String model, String price) {
    }

    public PC_MODEL(String id, String insertPart, String insertBrand, String insertModel, String insertPrice, String insertImage) {
    }

    public PC_MODEL() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
}
