package services.REST;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import entities.Student;
import manager.StudentManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/school")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

    @GET
    @Path("/student/add")
    public String addStudent(@QueryParam("id")int id, @QueryParam("name") String name, @DefaultValue("18")@QueryParam("age")int age,
                              @DefaultValue("computer")@QueryParam("department")String department,
                              @DefaultValue("1")@QueryParam("teacherid")int teacherid){
        Student student = new Student();
        student.setName(name);
        student.setDepartment(department);
        student.setTeacherId(teacherid);
        student.setAge(age);
        student.setId(id);
        try {
            StudentManager.getStudentManagerInstance().create(student);
        } catch (Exception e) {
            return "{\"An exception has been occurred \":\""+ e.toString()+"\"}";
        }
        return student.toJson();
    }
    @GET
    @Path("/student/remove")
    public String removeStudent(@QueryParam("id")int id){
        Student student ;
        try {
            student = (Student) StudentManager.getStudentManagerInstance().readById(id);
            StudentManager.getStudentManagerInstance().removeById(id);
        } catch (Exception e) {
            return "{\"An exception has been occurred \":\""+ e.toString()+"\"}";
        }
        return student.toJson() ;
    }
    @GET
    @Path("/student/getList")
    public Student[] getList(){
        Student[] students =null    ;
//        JsonArray jsonElements;
        try {
            students = (Student[]) StudentManager.getStudentManagerInstance().getList();
//            jsonElements = new JsonArray(students.length);
//            for (Student student : students) {
//                jsonElements.add(student.toJson());
//            }
        } catch (Exception e) {
//            return "{\"An exception has been occurred \":\""+ e.toString()+"\"}";
        }
//        return jsonElements.toString();
        return students;
    }
}
