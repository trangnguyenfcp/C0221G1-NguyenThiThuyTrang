package controller;

import model.bean.Contract;
import model.bean.Service;
import model.service.ContractService;
import model.service.implement.ContractServiceImp;

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
import java.util.Map;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ContractService contractService = new ContractServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try{
            switch (action){
                case "create":
                    createContract(request, response);
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
                    listContract(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        String contractStartDate = request.getParameter("contractStartDate");
        String contractEndDate = request.getParameter("contractEndDate");
        int contractDeposit = Integer.parseInt(request.getParameter("contractDeposit"));
        int id = (int)(Math.random() * 10000);
        Contract contract = new Contract(id, employeeId, customerId, serviceId, contractStartDate, contractEndDate,contractDeposit);
        contractService.insertContract(contract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/contract/create.jsp");
        request.setAttribute("message", "Contract was edited");
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
//                    showEditForm(request, response);
                    break;
                case "delete":
//                    showDeleteForm(request, response);
                    break;
                case "search":
//                    showSearch(request, response);
                    break;
                default:
                    listContract(request, response);

                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Map<Integer, String> listEmployee = contractService.selectAllEmployeeId();
        request.setAttribute("listEmployee", listEmployee);
        Map<Integer, String> listCustomer = contractService.selectAllCustomerId();
        request.setAttribute("listCustomer", listCustomer);
        Map<Integer, String> listService = contractService.selectAllServiceId();
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/contract/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Contract> contracts = new ArrayList<>();
        contracts = contractService.selectAllContracts();
        request.setAttribute("contracts", contracts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/list.jsp");
        requestDispatcher.forward(request, response);
    }

}
