package controller;

import model.bean.Customer;
import model.bean.CustomerUsingService;
import model.service.CustomerUsingServiceService;
import model.service.implement.CustomerUsingServiceServiceImp;

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

@WebServlet(name = "CustomerUsingServiceServlet", urlPatterns = "/customer_using_service")
public class CustomerUsingServiceServlet extends HttpServlet {
    CustomerUsingServiceService customerUsingServiceService = new CustomerUsingServiceServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
//                    showCreateForm(request, response);
                    break;
                case "edit":
//                    showEditForm(request, response);
                    break;
                case "delete":
//                    showDeleteForm(request, response);
                    break;
                case "search":
//                    showSearch(request, response);
                    break;
                default:

                    listCustomerUsingService(request, response);

                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listCustomerUsingService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<CustomerUsingService> customers = new ArrayList<>();
        customers = customerUsingServiceService.selectAllCustomersUsingService();
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer_using_service/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
