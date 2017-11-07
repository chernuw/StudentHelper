package edu.iba.sh.dao.db2;

import edu.iba.sh.bean.Group;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.GroupDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Db2GroupDAOImpl extends Db2AbstractDAO implements GroupDAO {

    private static Logger logger = LogManager.getLogger("edu.iba.sh.dao.db2");

    private static final String GET_ALL = "SELECT GROUP_NUMBER, AVG_MARK FROM LAPUSHA.GROUPS";
    private static final String GET_BY_ID = "SELECT GROUP_NUMBER, AVG_MARK  FROM LAPUSHA.GROUPS WHERE GROUP_NUMBER = ?";
    private static final String UPDATE = "UPDATE LAPUSHA.GROUPS SET GROUP_NUMBER = ?, AVG_MARK = ? WHERE GROUP_NUMBER = ?";
    private static final String DELETE = "DELETE FROM LAPUSHA.GROUPS WHERE GROUP_NUMBER = ?";
    private static final String INSERT = "INSERT INTO LAPUSHA.GROUPS (GROUP_NUMBER, AVG_MARK) VALUES (?, ?)";

    @Override
    public List<Group> getAllGroups() throws DAOException {
        logger.trace("DB2.getAllGroups()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL);
            set = statement.executeQuery();

            List<Group> list = new ArrayList<Group>();
            while (set.next()) {
                Group group = new Group();
                Double avgMark = Double.parseDouble(set.getString("AVG_MARK"));
                group.setAvgMark(avgMark);
                group.setGroupNumber(set.getString("GROUP_NUMBER"));
                list.add(group);
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
    public Group getGroupById(String id) throws DAOException {
        logger.trace("DB2.getGroupById()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID);
            statement.setString(1, id);
            set = statement.executeQuery();

            if (set.next()) {
                Group group = new Group();
                Double avgMark = Double.parseDouble(set.getString("AVG_MARK"));
                group.setAvgMark(avgMark);
                group.setGroupNumber(set.getString("GROUP_NUMBER"));
                return group;
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
    public boolean updateGroup(String id, Group group) throws DAOException {
        logger.trace("DB2.updateGroup()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, group.getGroupNumber());
            statement.setString(2, group.getAvgMark().toString());
            statement.setString(3, id);
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
    public boolean deleteGroupById(String id) throws DAOException {
        logger.trace("DB2.deleteGroupById()");
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
    public void addGroup(Group group) throws DAOException {
        logger.trace("DB2.addGroup()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, group.getGroupNumber());
            statement.setString(2, group.getAvgMark().toString());
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
}
