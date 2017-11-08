package edu.iba.sh.dao;

import edu.iba.sh.bean.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers() throws DAOException;

    User getUserById(String id) throws DAOException;

    boolean updateUser(String id, User user) throws DAOException;

    boolean deleteUserById(String id) throws DAOException;

    void addUser(User user) throws DAOException;

    User getUserByIdAndPassword(String id, String password) throws DAOException;

}
