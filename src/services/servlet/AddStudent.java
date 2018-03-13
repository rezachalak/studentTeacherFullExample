package services.servlet

import entities.Student;
import manager.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        int id = Integer.valueOf(request.getParameter("id"));
        int age = Integer.valueOf(request.getParameter("age"));
        int teacherid = Integer.valueOf(request.getParameter("teacherid"));
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        Student student = new Student();
        student.setId(id);
        student.setAge(age);
        student.setTeacherId(teacherid);
        student.setDepartment(department);
        student.setName(name);
        PrintWriter out = response.getWriter();
        out.println( student.toString());
        try {
            StudentManager stdMgr = StudentManager.getStudentManagerInstance();
            stdMgr.create(student);
        } catch (Exception e) {
            out.println(response.getStatus());
        }

        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
