package dao;

import entities.*;
import java.sql.SQLException;

public class TeacherDAO extends DAO implements CRUD{
    private static TeacherDAO teacherDAOInstance = new TeacherDAO();

    static {

    }

    public static TeacherDAO getTeacherDAOInstance() {
        return teacherDAOInstance;
    }
    
    private TeacherDAO()  {
        super();
    }
    
    @Override
    public Boolean create(Entity entity) throws SQLException {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            Teacher teacher = (Teacher) entity;
            ps = connection.prepareStatement("Insert into teachers (id , name, department) " +
                "values (?,?,?);");
            ps.setInt(1, teacher.getId());
            ps.setString(2, teacher.getTeacherName());
            ps.setString(3, teacher.getDepartment());
            ps.executeUpdate();
           
            return true; 
        }catch(SQLException e){
            throw e;
        }finally{
            try {ps.close(); } catch (SQLException e) {throw e;}
            try {connection.close(); } catch (SQLException e) {throw e;}
        }
    }

    @Override
    public Entity read(Integer id) throws Exception {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Teacher teacher = new Teacher();
            ps = connection.prepareStatement("SELECT * FROM teachers WHERE id = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            teacher.setId(rs.getInt(1));
            teacher.setTeacherName(rs.getString(2));
            teacher.setDepartment(rs.getString(3));
            return teacher;
        } catch (SQLException e) {
            throw e;
        }finally{
            try {ps.close(); } catch (SQLException e) {throw e;}
            try {rs.close(); } catch (SQLException e) {throw e;}
            try {connection.close(); } catch (SQLException e) {throw e;}
        }
    }

    @Override
    public Boolean update(Entity entity) throws Exception {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Teacher teacher = (Teacher) entity;
            ps = connection.prepareStatement("UPDATE teachers SET name=? , department" +
                "WHERE id = ?");
            ps.setString(1, teacher.getTeacherName());
            ps.setString(2, teacher.getDepartment());
            ps.setInt(4, teacher.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }finally{
            try {ps.close(); } catch (SQLException e) {throw e;}
            try {connection.close(); } catch (SQLException e) {throw e;}
        }
    }

    @Override
    public Boolean delete(Integer id) throws SQLException {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ps = connection.prepareStatement("DELETE FROM teachers WHERE id =?;");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }finally{
            try {ps.close(); } catch (SQLException e) {throw e;}
            try {connection.close(); } catch (SQLException e) {throw e;}
    }
    }


    @Override
     public Entity[] getList() throws SQLException {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ps= connection.prepareStatement("SELECT * FROM teachers");
            rs= ps.executeQuery();
            rs.last();
            int n = rs.getRow();
            Teacher[] tchrs = new Teacher[n];
            rs.first();
            int i=0;
            do{
                    tchrs[i] = new Teacher();
                    tchrs[i].setId(rs.getInt("id"));
                    tchrs[i].setTeacherName(rs.getString("name"));
                    tchrs[i].setDepartment(rs.getString("department"));
                    ++i;
            }while (rs.next());
            return tchrs;
        } catch (SQLException e) {
            throw e;
        }finally{
            try {ps.close(); } catch (SQLException e) {throw e;}
            try {rs.close(); } catch (SQLException e) {throw e;}
            try {connection.close(); } catch (SQLException e) {throw e;}
        }
    }
}
