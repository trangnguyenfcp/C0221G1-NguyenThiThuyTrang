package model.repository;

import model.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static final String SELECT_USER_BY_ID = "select* from users where id=?;";
    public static final String SELECT_ALL_USERS = "select* from users;";
    public static final String INSERT_NEW_USER = "insert into users\n" +
            "value(?, ?, ?, ?);";
public static final  String UPDATE_USER_BY_ID = "update users\n" +
        "set `name`=?, email=?, country = ?\n" +
        "where id = ?;";
    public static final String DELETE_USER = "delete from users where id = ?;";

    BaseRepository baseRepository = new BaseRepository();

    public void insertUser(User user) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
        preparedStatement.setInt(1,user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getCountry());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

    }


    public User selectUser(int id) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
                preparedStatement.close();
                connection.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


    public List<User> selectAllUsers() throws SQLException{
        Connection connection = baseRepository.connectDataBase();
        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
                users.add(user);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public boolean deleteUser(int id) throws SQLException {
        boolean check;
        try (Connection connection = baseRepository.connectDataBase();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);) {
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        }
        return check;
    }


    public boolean updateUser(int id, User user) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID);

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getCountry());
        preparedStatement.setInt(4, id);
        check = preparedStatement.executeUpdate()>0;
        preparedStatement.close();
        connection.close();
        return check;
    }
}
