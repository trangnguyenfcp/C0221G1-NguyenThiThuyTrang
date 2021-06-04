package controller;

import model.bean.Customer;
import model.service.CustomerService;
import model.service.implement.CustomerServiceImp;

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

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try{
        switch (action){
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "view":
//                viewCustomer(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("customer_id"));
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String customerName = request.getParameter("customer_name");
        String customerBirthday = request.getParameter("customer_birthday");
        int customerGender = Integer.parseInt(request.getParameter("customer_gender"));
        String customerIdCard = request.getParameter("customer_id_card");
        String customerPhone = request.getParameter("customer_phone");
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");
        Customer customer = new Customer(id, customerTypeId, customerName, customerBirthday,customerGender,customerIdCard,customerPhone,customerEmail,customerAddress);
        boolean check = customerService.updateCustomer(id, customer);
        RequestDispatcher dispatcher;
        if (!check) {
            dispatcher = request.getRequestDispatcher("view/customer/error_404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("customer_id"));
        Customer customer = customerService.selectCustomer(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("view/customer/error_404.jsp");
        } else {
            customerService.deleteCustomer(id);
            try {
                response.sendRedirect("customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String customerName = request.getParameter("customer_name");
        String customerBirthday = request.getParameter("customer_birthday");
        int customerGender = Integer.parseInt(request.getParameter("customer_gender"));
        String customerIdCard = request.getParameter("customer_id_card");
        String customerPhone = request.getParameter("customer_phone");
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");
        int id = (int)(Math.random() * 10000);

        Customer customer = new Customer(id, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard,customerPhone, customerEmail, customerAddress);
        customerService.insertCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/create.jsp");
        request.setAttribute("message", "Customer was edited");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String keyword = request.getParameter("customerName");
        List<Customer> customers = customerService.findByName(keyword);
        RequestDispatcher dispatcher;
        if(customers.size() == 0){
            dispatcher = request.getRequestDispatcher("/view/customer/error_404.jsp");
        } else {
            request.setAttribute("customers", customers);
            dispatcher = request.getRequestDispatcher("/view/customer/result_of_search.jsp");
        }
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
        try{
        switch (action) {
            case "create":
                    showCreateForm(request, response);
                break;
            case "edit":
                    showEditForm(request, response);
                break;
            case "delete":
                    showDeleteForm(request, response);
                break;
            case "search":
                    showSearch(request, response);
                break;
            default:

                    listCustomer(request, response);

                break;
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/search.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher;
        Customer customer = customerService.selectCustomer(id);
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("view/customer/error_404.jsp");

        } else {
            request.setAttribute("customer", customer);
            requestDispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        }
        requestDispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomer(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("/view/customer/error_404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("/view/customer/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        customers = customerService.selectAllCustomers();
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        requestDispatcher.forward(request, response);
    }

}
