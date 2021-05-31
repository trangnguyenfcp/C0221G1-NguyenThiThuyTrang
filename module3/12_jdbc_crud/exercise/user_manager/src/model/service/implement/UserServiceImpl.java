package model.service.implement;

import model.bean.User;
import model.repository.UserRepository;
import model.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepository();
    @Override
    public void insertUser(User user) throws SQLException {
         userRepository.insertUser(user);

    }

    @Override
    public User selectUser(int id) throws SQLException {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        return userRepository.selectAllUsers();
    }

    @Override
    public List<User> findByCountry(String country) throws SQLException {
        return userRepository.findByCountry(country);
    }

    @Override
    public void sortByName(List<User> users) throws SQLException {
        userRepository.sortByName(users);

    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(int id, User user) throws SQLException {
        return userRepository.updateUser(id, user);
    }
}
