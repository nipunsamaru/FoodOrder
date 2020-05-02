package com.research.foodorder.Models;

public class Shop {

    private String shopId;
    private String Name;
    private String Location;
    private float rating;
    private String image;

    public Shop(String shopId, String name, String location, float rating, String image) {
        Name = name;
        Location = location;
        this.rating = rating;
        this.image = image;
        this.shopId=shopId;
    }

    public Shop() {

    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
