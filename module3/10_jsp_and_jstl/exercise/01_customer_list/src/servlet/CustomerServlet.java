package servlet;
import Customer.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet(name = "CustomerServlet", urlPatterns = {""})
public class CustomerServlet extends HttpServlet {
    ArrayList<Customer> list = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        list.add(new Customer("Trang", "18/02/1998", "Hue", "https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/other/cat_relaxing_on_patio_other/1800x1200_cat_relaxing_on_patio_other.jpg"));
        list.add(new Customer("Phong", "17/02/1998", "Hue", "https://upload.wikimedia.org/wikipedia/commons/c/c7/Tabby_cat_with_blue_eyes-3336579.jpg"));
        list.add(new Customer("Huynh", "23/12/1996", "Da Nang", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSg4zsWbCjRW4C4cUSoc1XNH_eaqPzo32Hr4q6nay2h3bvRETC1zgYgea82HoIHHWpaqwA&usqp=CAU"));
        list.add(new Customer("Hoang", "02/05/1996", "Quang Nam", "https://static.toiimg.com/photo/msid-67586673/67586673.jpg?3918697"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", list);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
