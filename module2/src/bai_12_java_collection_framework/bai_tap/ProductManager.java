package bai_12_java_collection_framework.bai_tap;

import bai_12_java_collection_framework.thuc_hanh.Student;

import java.util.*;

import java.util.ArrayList;

public class ProductManager implements Comparator<Product> {
    static LinkedList<Product> list = new LinkedList<>();

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Product coca = new Product("5", "Coca", 5);
        Product pepsi = new Product("2", "Pepsi", 6);
        Product tiger = new Product("3", "Tiger", 10);
        Product huda = new Product("4", "Huda", 9);
        productManager.add(coca);
        productManager.add(pepsi);
        productManager.add(tiger);
        productManager.add(huda);
        System.out.println(productManager.toString());
        productManager.update(coca, "5", "Coca", 4);
        System.out.println(productManager.toString());
        productManager.remove(tiger);
        System.out.println(productManager.toString());
        Collections.sort(list, productManager);
        System.out.println(productManager.toString());

    }

    public void add(Product product) {
        list.add(product);
    }

    public void update(Product product, String id, String name, int price) {
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
    }

    public void remove(Product product) {
        list.remove(product);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public int compare(Product product1, Product product2) {
        return product1.getId().compareTo(product2.getId());
    }
}
