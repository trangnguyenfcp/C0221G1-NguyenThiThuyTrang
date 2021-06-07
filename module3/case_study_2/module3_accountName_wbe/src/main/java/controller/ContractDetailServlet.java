package controller;

import model.bean.Contract;
import model.bean.ContractDetail;
import model.service.ContractDetailService;
import model.service.ContractService;
import model.service.implement.ContractDetailServiceImp;
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

@WebServlet(name = "ContractDetailServlet", value = "/contract_detail")
public class ContractDetailServlet extends HttpServlet {
        ContractDetailService  contractDetailService = new ContractDetailServiceImp();
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if(action == null){
                action = "";
            }
            try{
                switch (action){
                    case "create":
                        createContractDetail(request, response);
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
                        listContractDetail(request, response);
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

        private void createContractDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
            int contractId = Integer.parseInt(request.getParameter("contractId"));
            int attachServiceId = Integer.parseInt(request.getParameter("attachServiceId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int id = (int)(Math.random() * 10000);
            ContractDetail contractDetail = new ContractDetail(id, contractId, attachServiceId, quantity);
            contractDetailService.insertContractDetail(contractDetail);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/contract_detail/create.jsp");
            request.setAttribute("message", "Contract detail was edited");
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
                        listContractDetail(request, response);

                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
            List<Integer> contractIds = contractDetailService.selectAllContractId();
            request.setAttribute("contractIds", contractIds);
            Map<Integer, String> attachServiceIds = contractDetailService.selectAllAttachServiceId();
            request.setAttribute("attachServiceIds", attachServiceIds);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/contract_detail/create.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        private void listContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
            List<ContractDetail> contractDetails = new ArrayList<>();
            contractDetails = contractDetailService.selectAllContractDetails();
            request.setAttribute("contractDetails", contractDetails);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract_detail/list.jsp");
            requestDispatcher.forward(request, response);
        }

    }
