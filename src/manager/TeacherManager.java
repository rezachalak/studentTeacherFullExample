package manager;

import dao.TeacherDAO;
import entities.Entity;

public class TeacherManager implements Manager{
    private TeacherDAO tchrDAO = TeacherDAO.getTeacherDAOInstance();
    private static TeacherManager teacherManagerInstance = new TeacherManager();

    public static TeacherManager getTeacherManagerInstance() {
        return teacherManagerInstance;
    }
    
    private TeacherManager(){}
    
    @Override
    public Boolean create(Entity entity) throws Exception {
        return tchrDAO.create(entity);
    }

    @Override
    public Entity readById(Integer id) throws Exception {
        return tchrDAO.read(id);
    }

    @Override
    public Boolean update(Entity entity) throws Exception {
        return tchrDAO.update(entity);
    }

    @Override
    public Boolean removeById(Integer id) throws Exception {
        return tchrDAO.delete(id);
    }

    @Override
    public Entity[] getList() throws Exception {
        return tchrDAO.getList();
    }
    
}
