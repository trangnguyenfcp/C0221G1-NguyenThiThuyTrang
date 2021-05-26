import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculator", value = "/discount")
public class ProductDiscountCalculator extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDes = request.getParameter("productDes");
        Double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        Double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));
        Double discountAmount = listPrice * discountPercent * 0.01;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("Product Description: " + productDes);
        writer.println("List Price: " + listPrice);
        writer.println("Discount Percent: " + discountPercent + "%");
        writer.println("Discount Amount: " + discountAmount);
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}