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
    public List<User> findByCountry(String keyword) throws SQLException {
        return userRepository.findByCountry(keyword);
    }

    @Override
    public List<User> sortByName(List<User> users) throws SQLException {
       return userRepository.sortByName(users);

    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(int id, User user) throws SQLException {
        return userRepository.updateUser(id, user);
    }

    @Override
    public User getUserById(int id) throws SQLException {
        return userRepository.getUserById(id);
    }

    @Override
    public void addUserTransaction(User user, int[] permission) {
        userRepository.addUserTransaction(user,permission);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        userRepository.insertUserStore(user);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        userRepository.insertUpdateUseTransaction();
    }

    @Override
    public List<User> selectAllUsersStore() {
        return userRepository.selectAllUsersStore();
    }

    @Override
    public boolean updateUserStore(int id, User user) {
     return  userRepository.updateUserStore(id, user);
    }

    @Override
    public boolean deleteUserStore(int id) {
        return userRepository.deleteUserStore(id);
    }
}
