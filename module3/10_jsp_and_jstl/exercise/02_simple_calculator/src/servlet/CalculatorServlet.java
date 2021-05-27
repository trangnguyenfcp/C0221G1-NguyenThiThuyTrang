package servlet;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {

    public int calculate(int firstOperand, String sign, int secondOperand) throws Exception{
        int result;
        switch (sign){
            case "+":
                result = firstOperand+secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand*secondOperand;
                break;
            default:
                result = firstOperand/secondOperand;

        }
        return result;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int firstOperand = Integer.parseInt(request.getParameter("firstOperand"));
        int secondOperand = Integer.parseInt(request.getParameter("secondOperand"));
        String sign = request.getParameter("sign");
        int result = 0;
        try {
            result = calculate(firstOperand, sign, secondOperand);
            request.setAttribute("Result1",result);
        } catch (Exception e) {
            request.setAttribute("Result1","Second operand <> 0");
            System.out.println("Second operand <> 0");
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request,response);
    }
}
