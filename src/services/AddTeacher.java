package services;

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

@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setDepartment(department);
        teacher.setTeacherName(name);

        PrintWriter out = response.getWriter();
        out.println( teacher);

        try {
            TeacherManager tchrMgr = TeacherManager.getTeacherManagerInstance();
            tchrMgr.create(teacher);
        } catch (Exception e) {
            out.println( "Exception Occured: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
