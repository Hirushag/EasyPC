package com.example.easypc;

public class insert_pc_parts_model {

    private String id,part,brand,model,imageID;
    private float price;



    public insert_pc_parts_model(String id,String part, String brand, String model, String imageID, float price) {
        this.id=id;
        this.part = part;
        this.brand = brand;
        this.model = model;
        this.imageID = imageID;
        this.price = price;
    }

    public insert_pc_parts_model(String id,String part, String brand, String model, float price) {
    }

    public insert_pc_parts_model() {

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageID() {
        return imageID;
    }
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
}
