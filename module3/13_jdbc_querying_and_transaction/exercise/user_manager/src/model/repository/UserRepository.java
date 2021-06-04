package model.repository;

import model.bean.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class UserRepository {
    public static final String SELECT_USER_BY_ID = "select* from users where id=?;";
    public static final String SELECT_ALL_USERS = "select* from users;";
    public static final String INSERT_NEW_USER = "insert into users\n" +
            "value(?, ?, ?, ?);";
    public static final String UPDATE_USER_BY_ID = "update users\n" +
            "set `name`=?, email=?, country = ?\n" +
            "where id = ?;";
    public static final String DELETE_USER = "delete from users where id = ?;";
    public static final String FIND_BY_COUNTRY = "select* from users\n" +
            "where country like ?;";
    public static final String SORT_BY_NAME = "select* from users\n" +
            "order by `name`;";
    public static String GET_USER_BY_ID = "CALL get_user_by_id(?)";
    public static String INSERT_USER_STORE = "CALL insert_user(?,?,?)";
    public static String SQLPIVOT = "INSERT INTO user_permission(user_id,permission_id)"

            + "VALUES(?,?)";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"


            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";
    private static final String SELECT_USERS_STORE = "CALL user_list;";
    private static final String UPDATE_USER_STORE = "call update_user(?,?,?,?);";
    private static final String DELETE_USER_STORE = "call delete_user(?);";
    BaseRepository baseRepository = new BaseRepository();


    public void insertUser(User user) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
        preparedStatement.setInt(1, user.getId());
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
            preparedStatement.setInt(1, id);
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


    public List<User> selectAllUsers() throws SQLException {
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
            check = preparedStatement.executeUpdate()>0;
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
        check = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        connection.close();
        return check;
    }

    public List<User> findByCountry(String keyword) throws SQLException {
        Connection connection = baseRepository.connectDataBase();
        List<User> users = new ArrayList<>();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_COUNTRY);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String country = resultSet.getString("country");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int id = resultSet.getInt("id");
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

    public List<User> sortByName(List<User> users) throws SQLException {

        Connection connection = baseRepository.connectDataBase();
        List<User> userList = new ArrayList<>();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String country = resultSet.getString("country");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int id = resultSet.getInt("id");
                user = new User(id, name, email, country);
                userList.add(user);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        users = userList;
        return userList;
    }

    public User getUserById(int id) throws SQLException {

        User user = null;

        // Step 1: Establishing a Connection

        try (Connection connection = baseRepository.connectDataBase();

             // Step 2:Create a statement using connection object

             CallableStatement callableStatement = connection.prepareCall(GET_USER_BY_ID);) {

            callableStatement.setInt(1, id);

            // Step 3: Execute the query or update query

            ResultSet rs = callableStatement.executeQuery();

            // Step 4: Process the ResultSet object.

            while (rs.next()) {

                String name = rs.getString("name");

                String email = rs.getString("email");

                String country = rs.getString("country");

                user = new User(id, name, email, country);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return user;

    }

    public void insertUserStore(User user) throws SQLException {


        // try-with-resource statement will auto close the connection.

        try (Connection connection = baseRepository.connectDataBase();

             CallableStatement callableStatement = connection.prepareCall(INSERT_USER_STORE);) {

            callableStatement.setString(1, user.getName());

            callableStatement.setString(2, user.getEmail());

            callableStatement.setString(3, user.getCountry());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void addUserTransaction(User user, int[] permissions) {

        Connection connection = null;

        // for insert a new user

        PreparedStatement pstmt = null;

        // for assign permission to user

        PreparedStatement pstmtAssignment = null;

        // for getting user id

        ResultSet rs = null;

        try {

            connection = baseRepository.connectDataBase();

            // set auto commit to false

            connection.setAutoCommit(false);

            //

            // Insert user

            //

            pstmt = connection.prepareStatement(INSERT_NEW_USER, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();

            // get user id

            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())

                userId = rs.getInt(1);

            //

            // in case the insert operation successes, assign permission to user

            //

            if (rowAffected == 1) {

                // assign permission to user


                pstmtAssignment = connection.prepareStatement(SQLPIVOT);

                for (int permissionId : permissions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permissionId);

                    pstmtAssignment.executeUpdate();

                }

                connection.commit();

            } else {

                connection.rollback();

            }

        } catch (SQLException ex) {

            // roll back the transaction

            try {

                if (connection != null)

                    connection.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (connection != null) connection.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }
    }

    public void insertUpdateWithoutTransaction() {

        try (Connection conn = baseRepository.connectDataBase();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {


            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);


            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            // Run list of update commands


            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

            psUpdate.setBigDecimal(2, new BigDecimal(999.99));


            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void insertUpdateUseTransaction() {

        try (Connection conn = baseRepository.connectDataBase();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);

            // start transaction block

            conn.setAutoCommit(false); // default true

            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            // Run list of update commands


            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

            psUpdate.setBigDecimal(1, new BigDecimal(999.99));


            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();


            // end transaction block, commit changes

            conn.commit();

            // good practice to set it back to default true

            conn.setAutoCommit(true);


        } catch (Exception e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

        }
    }

    public List<User> selectAllUsersStore() {
        List<User> users = new ArrayList<>();
        User user = null;
        try {
            Connection connection = baseRepository.connectDataBase();
            CallableStatement callableStatement = connection.prepareCall(SELECT_USERS_STORE);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
                users.add(user);
            }
            connection.close();
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean updateUserStore(int id, User user) {
        boolean check = false;
        try {
            Connection connection = baseRepository.connectDataBase();
            CallableStatement callableStatement = connection.prepareCall(UPDATE_USER_STORE);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            check = callableStatement.executeUpdate()>0;
            connection.close();
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean deleteUserStore(int id) {
        boolean check = false;
        try {
            Connection connection = baseRepository.connectDataBase();
            CallableStatement callableStatement = connection.prepareCall(DELETE_USER_STORE);
            callableStatement.setInt(1, id);
            check = callableStatement.executeUpdate()>0;
            connection.close();
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
