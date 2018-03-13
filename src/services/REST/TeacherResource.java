package services.REST;

import com.google.gson.JsonArray;
import entities.Teacher;
import manager.TeacherManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/school")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherResource {

    @GET
    @Path("/teacher/add")
    public String addTeacher(@QueryParam("id")int id, @QueryParam("name") String name,
                             @DefaultValue("computer")@QueryParam("department")String department){
        Teacher teacher = new Teacher();
        teacher.setTeacherName(name);
        teacher.setDepartment(department);
        teacher.setId(id);
        try {
            TeacherManager.getTeacherManagerInstance().create(teacher);
        } catch (Exception e) {
            return "{\"An exception has been occurred \":\""+ e.toString()+"\"}";
        }
        return teacher.toJson();
    }
    @GET
    @Path("/teacher/remove")
    public String removeTeacher(@QueryParam("id")int id){
        Teacher teacher ;
        try {
            teacher = (Teacher) TeacherManager.getTeacherManagerInstance().readById(id);
            TeacherManager.getTeacherManagerInstance().removeById(id);
        } catch (Exception e) {
            return "{\"An exception has been occurred \":\""+ e.toString()+"\"}";
        }
        return teacher.toJson() ;
    }
    @GET
    @Path("/teacher/getList")
    public String getList(){
        Teacher[] teachers ;
        JsonArray jsonElements;
        try {
            teachers = (Teacher[]) TeacherManager.getTeacherManagerInstance().getList();
            jsonElements = new JsonArray(teachers.length);
            for (Teacher teacher : teachers) {
                jsonElements.add(teacher.toJson());
            }
        } catch (Exception e) {
            return "{\"An exception has been occurred \":\""+ e.toString()+"\"}";
        }
        return jsonElements.toString();
    }
}
