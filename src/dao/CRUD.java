package dao;

import entities.Entity;

public interface CRUD {

    Boolean create(Entity entity) throws Exception;
    Entity read(Integer id) throws Exception;
    Boolean update(Entity entity) throws Exception;
    Boolean delete(Integer id) throws Exception;
    Entity[] getList() throws Exception;

}