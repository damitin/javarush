package com.javarush.task.task18.task1828;

public class Product {
    private int id;
    private String productName;
    private String price;
    private int quantity;

    public Product(int id, String productName, String price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String text) {
        id = Integer.parseInt(text.substring(0,8).replace(" ",""));
        productName = text.substring(8,38);
        price = text.substring(38,46).replace(" ","");
        quantity = Integer.parseInt(text.substring(46,50).replace(" ",""));
    }

    public String getString(){
        String formated = String.format("%-8d%-30s%-8s%-4d", id, productName, price, quantity);
        return formated;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
