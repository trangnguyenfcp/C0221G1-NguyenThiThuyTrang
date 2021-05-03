package ss17_io_binary_file_serialization.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Product> products){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<Product> readDataFromFile(String path){
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product (1, "SamSung", "SamSung", 1000, "No" ));
        products.add(new Product (2, "Nokia", "Microsoft", 300, "Yes" ));
        products.add(new Product (3, "Iphone", "Apple", 1200, "No" ));
        writeToFile("D:\\Source\\products.txt", products);
        List< Product> productDataFromFile = readDataFromFile("D:\\Source\\products.txt");
        for (Product product : productDataFromFile){
            System.out.println(product);
        }
    }
}
