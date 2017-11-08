package edu.iba.sh.dao.db2;

import edu.iba.sh.bean.User;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Db2UserDAOImpl extends Db2AbstractDAO implements UserDAO {

    private static final String GET_ALL = "SELECT \"USER\", PASSWORD, ROLE FROM LAPUSHA.USERS";
    private static final String GET_BY_ID = "SELECT \"USER\", PASSWORD, ROLE FROM LAPUSHA.USERS WHERE \"USER\" = ?";
    private static final String UPDATE = "UPDATE LAPUSHA.USERS SET \"USER\" = ?, PASSWORD = ?, ROLE = ? WHERE \"USER\" = ?";
    private static final String DELETE = "DELETE FROM LAPUSHA.USERS WHERE \"USER\" = ?";
    private static final String INSERT = "INSERT INTO LAPUSHA.USERS (\"USER\", PASSWORD, ROLE) VALUES (?, ?, ?)";
    private static final String GET_BY_ID_PASSWORD = "SELECT \"USER\", PASSWORD, ROLE FROM LAPUSHA.USERS WHERE \"USER\" = ? AND PASSWORD = ?";
    private static Logger logger = LogManager.getLogger("edu.iba.sh.dao.db2");

    @Override
    public List<User> getAllUsers() throws DAOException {
        logger.trace("DB2.getAllUsers()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL);
            set = statement.executeQuery();

            List<User> list = new ArrayList<User>();
            while (set.next()) {
                User user = new User();
                String role = set.getString("ROLE").toUpperCase();
                user.setRole(role);
                user.setPassword(set.getString("PASSWORD"));
                user.setUser(set.getString("USER"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (set != null) {
                    set.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public User getUserById(String id) throws DAOException {
        logger.trace("DB2.getUserById()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID);
            statement.setString(1, id);
            set = statement.executeQuery();

            if (set.next()) {
                User user = new User();
                String role = set.getString("ROLE").toUpperCase();
                user.setRole(role);
                user.setUser(set.getString("USER"));
                user.setPassword(set.getString("PASSWORD"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (set != null) {
                    set.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public boolean updateUser(String id, User user) throws DAOException {
        logger.trace("DB2.updateUser()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, user.getUser());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setString(4, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public boolean deleteUserById(String id) throws DAOException {
        logger.trace("DB2.deleteUserById()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(DELETE);
            statement.setString(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public void addUser(User user) throws DAOException {
        logger.trace("DB2.addUser()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, user.getUser());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public User getUserByIdAndPassword(String id, String password) throws DAOException {
        logger.trace("DB2.getUserByIdAndPassword()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID_PASSWORD);
            statement.setString(1, id);
            statement.setString(2, password);
            set = statement.executeQuery();

            if (set.next()) {
                User user = new User();
                String role = set.getString("ROLE").toUpperCase();
                user.setRole(role);
                user.setUser(set.getString("USER"));
                user.setPassword(set.getString("PASSWORD"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (set != null) {
                    set.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

}
