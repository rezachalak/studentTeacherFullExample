package dao;

import entities.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO extends DAO implements CRUD{
    private static StudentDAO studentDAOInstance;

    static {
        try {
            studentDAOInstance = new StudentDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private StudentDAO() throws Exception{
        super();
    }
    
    public static StudentDAO getStudentDAOInstance() {
        return studentDAOInstance;
    }
    
    @Override
    public Boolean create(Entity entity) throws SQLException {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            Student student = (Student) entity;
            ps = connection.prepareStatement("Insert into students (id , name , age , department , teacherid) " +
                "values (?,?,?,?,?);");
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getDepartment());
            ps.setInt(5, student.getTeacherId());
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
            Student student = new Student();
            ps = connection.prepareStatement("SELECT * FROM students WHERE id = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            student.setAge(rs.getInt(3));
            student.setDepartment(rs.getString(4));
            student.setTeacherId(rs.getInt(5));
            return student;
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
            Student student = (Student) entity;
            ps = connection.prepareStatement("UPDATE students SET name=? , age=? , department=? , teacherid=? " +
                "WHERE id = ?");
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getDepartment());
            ps.setInt(4, student.getTeacherId());
            ps.setInt(5, student.getId());
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
            ps = connection.prepareStatement("DELETE FROM students WHERE id =?;");
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
            ps = connection.prepareStatement("SELECT * FROM students");
            rs = ps.executeQuery();
            rs.last();
            int n = rs.getRow();
            Student[] stds = new Student[n];
            rs.first();
            int i = 0;
            do {
                stds[i] = new Student();
                stds[i].setId(rs.getInt("id"));
                stds[i].setName(rs.getString("name"));
                stds[i].setAge(rs.getInt("age"));
                stds[i].setDepartment(rs.getString("department"));
                stds[i].setTeacherId(rs.getInt("teacherid"));
                ++i;
            } while (rs.next());
            return stds;
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw e;
            }
            try {
                rs.close();
            } catch (SQLException e) {
                throw e;
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw e;
            }
        }
    }
}
