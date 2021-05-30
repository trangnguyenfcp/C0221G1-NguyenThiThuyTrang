package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 12", "Apple", 1000));
        products.put(2, new Product(2, "Samsung S21", "Samsung", 900));
        products.put(3, new Product(3, "Vsmart V3", "Vsmart", 120));
        products.put(4, new Product(4, "Oppo Find 7", "Oppo", 400));
        products.put(5, new Product(5, "Iphone 11 pro max", "Apple", 1100));
        products.put(6, new Product(6, "Sony Z21", "Sony", 500));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }


    public void save(Product product) {
        products.put(product.getId(), product);
    }


    public Product findById(int id) {
        return products.get(id);
    }


    public void update(int id, Product product) {
        products.put(id, product);
    }


    public List<Product> findByName(String name) {
        List<Product> search = new ArrayList<>();
        List<Product> productsList = new ArrayList<>(products.values());
        for (Product product: productsList){
            if (product.getName().equals(name)){
                search.add(product);
            }
        }
        return search;
    }


    public void remove(int id) {
        products.remove(id);
    }
}
