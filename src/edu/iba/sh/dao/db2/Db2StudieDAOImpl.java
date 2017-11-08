package edu.iba.sh.dao.db2;

import edu.iba.sh.bean.Studie;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.StudieDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Db2StudieDAOImpl extends Db2AbstractDAO implements StudieDAO {

    private static final String GET_ALL = "SELECT ID, NAME, HOURS, PROFESSOR_ID, AVG_MARK FROM LAPUSHA.STUDIES";
    private static final String GET_BY_ID = "SELECT ID, NAME, HOURS, PROFESSOR_ID, AVG_MARK FROM LAPUSHA.STUDIES WHERE ID = ?";
    private static final String UPDATE = "UPDATE LAPUSHA.STUDIES SET NAME = ?, HOURS = ?, PROFESSOR_ID = ?, AVG_MARK = ?  WHERE ID = ?";
    private static final String DELETE = "DELETE FROM LAPUSHA.STUDIES WHERE ID = ?";
    private static final String INSERT = "INSERT INTO LAPUSHA.STUDIES (NAME, HOURS, PROFESSOR_ID, AVG_MARK) VALUES (?, ?, ?, ?)";
    private static Logger logger = LogManager.getLogger("edu.iba.sh.dao.db2");

    @Override
    public List<Studie> getAllStudies() throws DAOException {
        logger.trace("DB2.getAllStudies()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL);
            set = statement.executeQuery();

            List<Studie> list = new ArrayList<Studie>();
            while (set.next()) {
                Studie studie = new Studie();
                studie.setId(Integer.parseInt(set.getString("ID")));
                studie.setName(set.getString("NAME"));
                studie.setHours(Integer.parseInt(set.getString("HOURS")));
                studie.setProfessorId(Integer.parseInt(set.getString("PROFESSOR_ID")));
                studie.setAvgMark(Double.parseDouble(set.getString("AVG_MARK")));
                list.add(studie);
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
    public Studie getStudieById(Integer id) throws DAOException {
        logger.trace("DB2.getStudieById()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID);
            statement.setInt(1, id);
            set = statement.executeQuery();

            if (set.next()) {
                Studie studie = new Studie();
                studie.setId(Integer.parseInt(set.getString("ID")));
                studie.setName(set.getString("NAME"));
                studie.setHours(Integer.parseInt(set.getString("HOURS")));
                studie.setProfessorId(Integer.parseInt(set.getString("PROFESSOR_ID")));
                studie.setAvgMark(Double.parseDouble(set.getString("AVG_MARK")));
                return studie;
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
    public boolean updateStudie(Integer id, Studie studie) throws DAOException {
        logger.trace("DB2.updateStudie()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, studie.getName());
            statement.setInt(2, studie.getHours());
            statement.setInt(3, studie.getProfessorId());
            statement.setDouble(4, studie.getAvgMark());
            statement.setInt(5, id);
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
    public boolean deleteStudieById(Integer id) throws DAOException {
        logger.trace("DB2.deleteStudieById()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, id);
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
    public void addStudie(Studie studie) throws DAOException {
        logger.trace("DB2.addStudie()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, studie.getName());
            statement.setInt(2, studie.getHours());
            statement.setInt(3, studie.getProfessorId());
            statement.setDouble(4, studie.getAvgMark());
            statement.executeUpdate();

            ResultSet set = statement.getGeneratedKeys();

            set.next();
            int id = set.getInt(1);
            studie.setId(id);

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
