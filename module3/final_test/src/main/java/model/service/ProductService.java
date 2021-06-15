package model.service;

import model.bean.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ProductService {
    public void insertProduct(Product product) throws SQLException;
    public Product selectProduct(int id) throws SQLException;
    public List<Product> selectAllProducts() throws SQLException;
    public boolean deleteProduct(int id) throws SQLException;
    public void updateProduct(int id, Product product) throws SQLException;
    public Map<Integer, String> selectAllCategory() throws SQLException;
    public List<Product> findByName(String keyword) throws SQLException;
}
