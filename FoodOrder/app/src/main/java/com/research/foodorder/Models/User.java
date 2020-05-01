package com.research.foodorder.Models;

public class User {

   // private String Uid;
    private String Name;
    private String Passsword;
    private boolean isSeller;
    private String Address;
    private String ShopName;

    public User() {

    }

    public User(String name, String passsword, boolean isSeller, String address, String shopName) {
        Name = name;
        Passsword = passsword;
        this.isSeller = isSeller;
        Address = address;
        ShopName = shopName;
    }

    public User(String name, String passsword) {
        Name = name;
        Passsword = passsword;
    }

    public String getPasssword() {
        return Passsword;
    }
    public void setPasssword(String passsword) {
        Passsword = passsword;
    }

    public String getShopName() {
        return ShopName;
    }
    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String addreess) {
        Address = addreess;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
