package services;

import entities.Student;
import manager.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet("/ListOfStudents")
public class ListOfStudents extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student[] students;
        PrintWriter out = response.getWriter();
        try {
            students = (Student[]) StudentManager.getStudentManagerInstance().getList();
            for (Student student : students) {
                out.println(student);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
