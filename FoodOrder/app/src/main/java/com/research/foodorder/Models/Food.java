package com.research.foodorder.Models;

public class Food {

    private String id;
    private String shopId;
    private String Name;
    private String Category;
    private Double Price;
    private int Qty;
    private String Url;

    public Food(){}
    public Food(String shopId,String name, String category, Double price, int qty, String url) {

        Name = name;
        Category = category;
        Price = price;
        Qty = qty;
        Url = url;
        this.shopId=shopId;
    }

    public Food(String id, String shopId, String name, String category, Double price, int qty, String url) {
        this.id = id;
        this.shopId = shopId;
        Name = name;
        Category = category;
        Price = price;
        Qty = qty;
        Url = url;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
