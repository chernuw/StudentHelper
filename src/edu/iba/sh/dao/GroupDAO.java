package edu.iba.sh.dao;

import edu.iba.sh.bean.Group;

import java.util.List;

public interface GroupDAO {

    List<Group> getAllGroups() throws DAOException;

    Group getGroupById(String id) throws DAOException;

    boolean updateGroup(String id, Group group) throws DAOException;

    boolean deleteGroupById(String id) throws DAOException;

    void addGroup(Group group) throws DAOException;
}
