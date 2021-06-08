package controller;

import model.bean.Customer;
import model.bean.Service;
import model.service.ServiceService;
import model.service.implement.ServiceServiceImp;

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

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try{
            switch (action){
                case "create":
                    createService(request, response);
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
                    listService(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String serviceCode = request.getParameter("serviceCode");
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        String numberOfFloors = request.getParameter("numberOfFloors");
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String poolArea = request.getParameter("poolArea");
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int id = (int)(Math.random() * 10000);
        if (numberOfFloors == ""){
            numberOfFloors = "0";
        }
        if (poolArea == ""){
            poolArea = "0";
        }
        Service service = new Service(id,serviceCode, serviceName, serviceArea, serviceCost, Integer.parseInt(numberOfFloors), serviceMaxPeople,serviceTypeId, Double.parseDouble(poolArea), standardRoom,descriptionOtherConvenience,rentTypeId);
        Map<String, String> mapMsg = serviceService.insertService(service);
        RequestDispatcher dispatcher;
        if (mapMsg.isEmpty()) {
            dispatcher = request.getRequestDispatcher("/view/service/create.jsp");
            dispatcher.forward(request,response);
            request.setAttribute("message", "Service was created");
        } else {
            request.setAttribute("msgCode", mapMsg.get("serviceCode"));
            showCreateForm(request,response);
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
                    listService(request, response);

                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/service/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Service> services = new ArrayList<>();
        services = serviceService.selectAllServices();
        request.setAttribute("services", services);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
