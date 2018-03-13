package manager;

import entities.Entity;

public interface Manager {
    public Boolean create(Entity entity) throws Exception;
    public Entity readById(Integer id) throws Exception;
    public Boolean update(Entity entity) throws Exception;
    public Boolean removeById(Integer id) throws Exception;
    public Entity[] getList() throws Exception;
    
}
