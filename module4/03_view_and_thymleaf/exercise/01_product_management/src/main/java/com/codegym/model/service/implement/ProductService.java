package com.codegym.model.service.implement;

import com.codegym.model.bean.Product;
import com.codegym.model.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 12", "1400", "Good", "Apple"));
        products.put(2, new Product(2, "Samsung S20", "500", "Good", "Samsung"));
        products.put(3, new Product(3, "Nokia 6", "350", "Good", "Nokia"));
        products.put(4, new Product(4, "Iphone X", "560", "Good", "Apple"));
        products.put(5, new Product(5, "Google Pixel 4", "1100", "Good", "Google"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
