package model.repository;

import model.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    BaseRepository baseRepository = new BaseRepository();
    public static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product;";
    public static final String SELECT_ALL_CATEGORY = "SELECT * FROM category;";
    public static final String INSERT_NEW_PRODUCT = "insert into product\n" +
            "value(?,?,?,?,?,?);";
    public static final String SELECT_PRODUCT_BY_ID = "select* from product where product_id=?;";
    public static final String DELETE_PRODUCT = "delete from product where product_id = ?;";
    public static final String UPDATE_PRODUCT_BY_ID = "update product\n" +
            "set product_name = ?,`product_price`=?, product_quantity=?, product_description = ?,category_id = ?\n" +
            "where product_id = ?;";
    public static final String FIND_BY_NAME = "select* from product\n" +
            "where product_na  me like ?;";
    public List<Product> selectAllProducts() throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<Product> products = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                double productPrice = resultSet.getDouble("product_price");
                int productQuantity = resultSet.getInt("product_quantity");
                String productDescription = resultSet.getString("product_description");
                int categoryId = resultSet.getInt("category_id");

                product = new Product(productId, productName, productPrice, productQuantity, productDescription, categoryId);
                products.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public Map<Integer, String> selectAllCategory() throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        Map<Integer, String> categoryMap = new HashMap<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int categoryId = resultSet.getInt("category_id");
                String categoryName  = resultSet.getString("category_name");
                categoryMap.put(categoryId, categoryName);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryMap;
    }
    public boolean insertProduct(Product product) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_PRODUCT);
        preparedStatement.setInt(1, product.getProductId());
        preparedStatement.setString(2, product.getProductName());
        preparedStatement.setDouble(3, product.getProductPrice());
        preparedStatement.setInt(4, product.getProductQuantity());
        preparedStatement.setString(5, product.getProductDescription());
        preparedStatement.setInt(6, product.getCategoryId());
        check = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        connection.close();
        return check;
    }
    public Product selectProduct(int id) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("product_name");
                double productPrice = resultSet.getDouble("product_price");
                int productQuantity = resultSet.getInt("product_quantity");
                String productDescription = resultSet.getString("product_description");
                int categoryId = resultSet.getInt("category_id");
                product = new Product(id, productName, productPrice, productQuantity, productDescription, categoryId);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
    public boolean deleteProduct(int id) throws SQLException {
        boolean check;
        try (Connection connection = baseRepository.connectDataBase();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);) {
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        }
        return check;
    }
    public boolean updateProduct(int id, Product product) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setDouble(2, product.getProductPrice());
        preparedStatement.setInt(3, product.getProductQuantity());
        preparedStatement.setString(4, product.getProductDescription());
        preparedStatement.setInt(5, product.getCategoryId());
        preparedStatement.setInt(6, id);
        check = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        connection.close();
        return check;
    }
    public List<Product> findByName(String keyword) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<Product> producrs = new ArrayList<>();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                double productPrice = resultSet.getDouble("product_price");
                int productQuantity = resultSet.getInt("product_quantity");
                String productDes = resultSet.getString("product_description");
                int categoryId = resultSet.getInt("category_id");
                product = new Product(productId,productName, productPrice, productQuantity, productDes, categoryId);
                producrs.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producrs;
    }
}
