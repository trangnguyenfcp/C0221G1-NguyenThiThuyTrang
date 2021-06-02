package controller;

import model.bean.User;
import model.service.UserService;
import model.service.implement.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/users"})
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createUser(request, response);
                    break;
                case "edit":
                    edit(request, response);
                    break;
                case "search":
                    search(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                        break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
//        boolean check = userService.updateUser(id, user);
        boolean check = userService.updateUserStore(id, user);
        RequestDispatcher dispatcher;
        if (!check) {
            dispatcher = request.getRequestDispatcher("view/user/error_404.jsp");
        } else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("/view/user/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User user = null;
        int id = (int) (Math.random() * 10000);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        user = new User(id, name, email, country);
//        userService.insertUser(user);
        userService.insertUserStore(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/user/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "search":
                    showSearch(request, response);
                    break;
                case "permission":

                    addUserPermission(request, response);

                    break;
                case "test-without-tran":

                    testWithoutTran(request, response);
                    break;
                case "test-use-tran":

                    testUseTran(request, response);
                    break;
                case "sort":
                    sortByName(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateUseTransaction();
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateWithoutTransaction();
    }

    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) {
        User user = new User(1000,"quan", "quan.nguyen@codegym.vn", "vn");

        int[] permission = {1, 2, 4};

        userService.addUserTransaction(user, permission);
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> users = new ArrayList<>();
        users=userService.selectAllUsers();
        users=userService.sortByName(users);
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/list.jsp");
        requestDispatcher.forward(request, response);
    }



    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/user/search.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String keyword = request.getParameter("country");
        List<User> users = userService.findByCountry(keyword);
        RequestDispatcher dispatcher;
        if(users.size() == 0){
            dispatcher = request.getRequestDispatcher("/view/user/error_404.jsp");
        } else {
            request.setAttribute("users", users);
            dispatcher = request.getRequestDispatcher("/view/user/result_of_search.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        userService.deleteUser(id);
        userService.deleteUserStore(id);

        List<User> users = userService.selectAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher;
//        User user = userService.selectUser(id);
        User user = userService.getUserById(id);
        if (user == null) {
            requestDispatcher = request.getRequestDispatcher("view/user/error_404.jsp");

        } else {
            request.setAttribute("user", user);
            requestDispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        }
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/create.jsp");
        requestDispatcher.forward(request, response);

    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> users = new ArrayList<>();
//        users = userService.selectAllUsers();
        users = userService.selectAllUsersStore();
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
