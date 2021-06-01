package controller;

import model.bean.Student;
import model.service.IStudentService;
import model.service.impl.StudentServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"","/student"})
public class StudentServlet extends HttpServlet {
    IStudentService studentService = new StudentServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                add(request,response);
                break;
            case "edit":
                update(request,response);
                break;
            case "delete":
                break;
            default:
                break;
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name =request.getParameter("name");
        int age =Integer.parseInt(request.getParameter("age"));
        String email =request.getParameter("email");
        Student student = new Student(name,age,email);
        boolean check = studentService.save(student);
        String message =null;
        if (check){
            message ="Thêm mới thành công";
        }else {
            message ="thêm mới thất bại";
        }
        List<Student> students = studentService.findByAll();
        request.setAttribute("students",students);
        request.setAttribute("message", message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/student/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
          int id = Integer.parseInt(request.getParameter("id"));
          String name = request.getParameter("name");
          int age = Integer.parseInt(request.getParameter("age"));
          String email = request.getParameter("email");
          Student student = new Student(id, name,age,email);
          boolean check = studentService.update(id,student);
          student = studentService.findById(id);
          if (check){
              request.setAttribute("message","Chỉnh sữa đã thành công");

          }else {
              request.setAttribute("message","Chỉnh sửa không thành công");
          }
        request.setAttribute("student", student);

          RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/student/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String action = request.getParameter("action");
         if (action==null){
             action="";
         }
        switch (action){
            case "add":
                showFomrAdd(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "delete":

                break;
            default:
                showStudentList(request,response);
                break;
        }
    }

    private void showFomrAdd(HttpServletRequest request, HttpServletResponse response) {
       RequestDispatcher requestDispatcher= request.getRequestDispatcher("/view/student/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher requestDispatcher;
        if (student==null){
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        }else {
            requestDispatcher = request.getRequestDispatcher("/view/student/edit.jsp");
            request.setAttribute("student",student);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = studentService.findByAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/student/list.jsp");
        request.setAttribute("students",students);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
