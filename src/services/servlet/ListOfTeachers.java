package services.servlet;

import entities.Student;
import entities.Teacher;
import manager.StudentManager;
import manager.TeacherManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ListOfTeachers")
public class ListOfTeachers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Teacher[] teachers ;
        try {
            teachers = (Teacher[]) TeacherManager.getTeacherManagerInstance().getList();
            for (Teacher teacher : teachers) {
                out.println(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
