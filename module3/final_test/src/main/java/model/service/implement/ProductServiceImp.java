package model.service.implement;

import model.bean.Product;
import model.repository.ProductRepository;
import model.service.ProductService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductService {
    ProductRepository productRepository = new ProductRepository();

    @Override
    public void insertProduct(Product product) throws SQLException {
productRepository.insertProduct(product);
    }

    @Override
    public Product selectProduct(int id) throws SQLException {
        return productRepository.selectProduct(id);
    }

    @Override
    public List<Product> selectAllProducts() throws SQLException {
        return productRepository.selectAllProducts();
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return productRepository.deleteProduct(id);
    }

    @Override
    public void updateProduct(int id, Product product) throws SQLException {
            productRepository.updateProduct(id,product);
    }

    @Override
    public Map<Integer, String> selectAllCategory() throws SQLException {
        return productRepository.selectAllCategory();
    }

    @Override
    public List<Product> findByName(String keyword) throws SQLException {
        return productRepository.findByName(keyword);
    }
}
