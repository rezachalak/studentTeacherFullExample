
package manager;

import dao.StudentDAO;
import entities.*;
import java.sql.SQLException;

public class StudentManager implements Manager{
    private StudentDAO studentDAOInstance = StudentDAO.getStudentDAOInstance();
    private static StudentManager  studentManagerInstance = new StudentManager();

    public static StudentManager getStudentManagerInstance() {
        return studentManagerInstance;
    }
    
    private StudentManager(){}
    
    @Override
    public Boolean create(Entity entity) throws Exception {
        return studentDAOInstance.create(entity);
    }

    @Override
    public Entity readById(Integer id) throws Exception {
        return studentDAOInstance.read(id);
    }

    @Override
    public Boolean update(Entity entity) throws Exception {
        return studentDAOInstance.update(entity);
    }

    @Override
    public Boolean removeById(Integer id) throws Exception {
        return studentDAOInstance.delete(id);
    }

    @Override
    public Entity[] getList() throws Exception {
        return studentDAOInstance.getList();
    }

}
