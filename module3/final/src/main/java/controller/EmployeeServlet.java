package controller;

import model.bean.Employee;
import model.service.EmployeeService;
import model.service.implement.EmployeeServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "view":
//                viewCustomer(request, response);
                    break;
                case "search":
//                    searchByName(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        Employee employee = new Employee(id, employeeName, employeeBirthday);
        Map<String, String> mapMsg = employeeService.updateEmployee(id, employee);
        RequestDispatcher dispatcher;
        if (mapMsg.isEmpty()) {
            request.setAttribute("employee", employee);
            request.setAttribute("message", "Employee was edited");
            dispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("msgName", mapMsg.get("name"));
            request.setAttribute("msgBirthday", mapMsg.get("birthday"));
            showEditForm(request,response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeService.selectEmployee(id);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("view/employee/error_404.jsp");
        } else {
            employeeService.deleteEmployee(id);
            try {
                response.sendRedirect("employee");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ParseException {
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        RequestDispatcher dispatcher;
        int id = (int) (Math.random() * 10000);
        Employee employee = new Employee(id, employeeName, employeeBirthday);
        Map<String, String> mapMsg = employeeService.insertEmployee(employee);
        if (mapMsg.isEmpty()) {
            dispatcher = request.getRequestDispatcher("/view/employee/create.jsp");
            dispatcher.forward(request,response);
            request.setAttribute("message", "Employee was created");
        } else {
            request.setAttribute("msgName", mapMsg.get("name"));
            request.setAttribute("msgBirthday", mapMsg.get("birthday"));
            showCreateForm(request,response);
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
//                    showDeleteForm(request, response);
                    break;
                case "search":
//                    showSearch(request, response);
                    break;
                default:

                    listEmployee(request, response);

                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher;
        Employee employee = employeeService.selectEmployee(id);
        if (employee == null) {
            requestDispatcher = request.getRequestDispatcher("view/employee/error_404.jsp");

        } else {
            request.setAttribute("employee", employee);
            requestDispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        }
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Employee> employees = new ArrayList<>();
        employees = employeeService.selectAllEmployees();
        request.setAttribute("employees", employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
