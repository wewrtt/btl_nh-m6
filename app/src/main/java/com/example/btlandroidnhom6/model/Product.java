package com.example.btlandroidnhom6.model;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
     private String name;
     private String codeProduct;
     private String images;
     private String description;
     private int price;
     private int quantity;
     private boolean isHot;
     private List<String> listCategoryId;
     private String userId;
     private String _id;
    public Product() {
     }

    public Product(String name, String images, String description, int price) {
        this.name = name;
        this.images = images;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String codeProduct, String images, String description, int price, int quantity, boolean isHot, List<String> listCategoryId, String userId) {
        this.name = name;
        this.codeProduct = codeProduct;
        this.images = images;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.isHot = isHot;
        this.listCategoryId = listCategoryId;
        this.userId = userId;
     }

     public String getName() {
        return name;
    }

     public void setName(String name) {
        this.name = name;
    }

     public String getCodeProduct() {
        return codeProduct;
    }

     public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

     public String getImages() {
        return images;
    }

     public void setImages(String images) {
        this.images = images;
    }

     public String getDescription() {
        return description;
    }

     public void setDescription(String description) {
        this.description = description;
    }

     public int getPrice() {
        return price;
    }

     public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isHot() {
        return isHot;
    }

     public void setHot(boolean hot) {
        isHot = hot;
    }

     public List<String> getListCategoryId() {
        return listCategoryId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setListCategoryId(List<String> listCategoryId) {
        this.listCategoryId = listCategoryId;
     }

     public String getUserId() {
        return userId;
    }

     public void setUserId(String userId) {
        this.userId = userId;
    }

}
