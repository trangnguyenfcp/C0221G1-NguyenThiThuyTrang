package controller;

import model.bean.Employee;
import model.bean.Service;
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
import java.util.ArrayList;
import java.util.List;

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
//                    updateCustomer(request, response);
                    break;
                case "delete":
//                    deleteCustomer(request, response);
                    break;
                case "view":
//                viewCustomer(request, response);
                    break;
                case "search":
//                searchProductByName(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String employeeName = request.getParameter("employeeName");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        String employeeSalary = request.getParameter("employeeSalary");
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail= request.getParameter("employeeEmail");
        String employeeAddress= request.getParameter("employeeAddress");
        int id = (int)(Math.random() * 10000);

        Employee employee = new Employee(id, employeeName, positionId, educationDegreeId, divisionId, username,employeeBirthday, employeeIdCard, employeeSalary,employeePhone,employeeEmail, employeeAddress);
        employeeService.insertEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/create.jsp");
        request.setAttribute("message", "Employee was edited");
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
//                    updateCustomer(request, response);
                    break;
                case "delete":
//                    deleteCustomer(request, response);
                    break;
                case "view":
//                viewCustomer(request, response);
                    break;
                case "search":
//                searchProductByName(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Employee> employees = new ArrayList<>();
        employees = employeeService.selectAllEmployees();
        request.setAttribute("employees", employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
