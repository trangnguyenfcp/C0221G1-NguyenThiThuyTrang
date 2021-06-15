package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.implement.ProductServiceImp;

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

@WebServlet(name = "ProductServlet",urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createProduct(request, response);
                    break;
                case "edit":
                    updateProduct(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                case "view":
//                viewCustomer(request, response);
                    break;
                case "search":
                    searchByName(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String keyword = request.getParameter("customerName");
        List<Product> products = productService.findByName(keyword);
        RequestDispatcher dispatcher;
        if (products.size() == 0) {
            dispatcher = request.getRequestDispatcher("/view/product/error_404.jsp");
        } else {
            request.setAttribute("products", products);
            dispatcher = request.getRequestDispatcher("/view/product/result_of_search.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productName");
        Double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
        String productDescription = request.getParameter("productDescription");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(id, productName, productPrice, productQuantity, productDescription, categoryId);
//        Map<String, String> mapMsg = customerService.updateCustomer(id, customer);
        RequestDispatcher dispatcher;
//        if (mapMsg.isEmpty()) {
            request.setAttribute("product", product);
            request.setAttribute("message", "Product was edited");
            dispatcher = request.getRequestDispatcher("/view/product/edit.jsp");
            dispatcher.forward(request, response);
//        } else {
//            request.setAttribute("msgCode", mapMsg.get("customerCode"));
//            request.setAttribute("msgPhone", mapMsg.get("customerPhone"));
//            showEditForm(request,response);
//        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
        String productDescription = request.getParameter("productDescription");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        RequestDispatcher dispatcher;
        int id = (int) (Math.random() * 10000);
        Product product = new Product(id, productName, productPrice, productQuantity, productDescription, categoryId);
      productService.insertProduct(product);
//        if (mapMsg.isEmpty()) {
            dispatcher = request.getRequestDispatcher("/view/product/create.jsp");
            dispatcher.forward(request,response);
            request.setAttribute("message", "Product was created");
//        } else {
//            request.setAttribute("msgCode", mapMsg.get("customerCode"));
//            request.setAttribute("msgPhone", mapMsg.get("customerPhone"));
//            request.setAttribute("msgIdCard", mapMsg.get("customerIdCard"));
//            request.setAttribute("msgEmail", mapMsg.get("customerEmail"));
//            showCreateForm(request,response);
//        }
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
                    showSearch(request, response);
                    break;
                default:

                    listProduct(request, response);

                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Map<Integer, String> categoryList = productService.selectAllCategory();
        request.setAttribute("categoryList", categoryList);
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher;
        Product product = productService.selectProduct(id);
        if (product == null) {
            requestDispatcher = request.getRequestDispatcher("view/product/error_404.jsp");

        } else {
            request.setAttribute("product", product);
            requestDispatcher = request.getRequestDispatcher("view/product/edit.jsp");
        }
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Map<Integer, String> categoryList = productService.selectAllCategory();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products = productService.selectAllProducts();
        request.setAttribute("products", products);
        Map<Integer, String> categoryList = productService.selectAllCategory();
//        List<String> categoryList = new ArrayList<>(categoryMap.values());
        request.setAttribute("categoryList", categoryList);
        products = productService.selectAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/list.jsp");
        requestDispatcher.forward(request, response);
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("productId"));
        Product product = productService.selectProduct(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("view/product/error_404.jsp");
        } else {
            productService.deleteProduct(id);
            try {
                response.sendRedirect("product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
