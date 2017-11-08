package edu.iba.sh.dao.mysql;

import edu.iba.sh.bean.Professor;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.ProfessorDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlProfessorDAOImpl extends MysqlAbstractDAO implements ProfessorDAO {

    private static final String GET_ALL = "SELECT ID, FIRST_NAME, SECOND_NAME, FATHER_NAME, BIRTH_DATE, AVG_MARK FROM LAPUSHA.PROFESSORS";
    private static final String GET_BY_ID = "SELECT ID, FIRST_NAME, SECOND_NAME, FATHER_NAME, BIRTH_DATE, AVG_MARK FROM LAPUSHA.PROFESSORS WHERE ID = ?";
    private static final String UPDATE = "UPDATE LAPUSHA.PROFESSORS SET FIRST_NAME = ?, SECOND_NAME = ?, FATHER_NAME = ?, BIRTH_DATE = ? , AVG_MARK = ? WHERE ID = ?";
    private static final String DELETE = "DELETE FROM LAPUSHA.PROFESSORS WHERE ID = ?";
    private static final String INSERT = "INSERT INTO LAPUSHA.PROFESSORS (FIRST_NAME, SECOND_NAME, FATHER_NAME, BIRTH_DATE, AVG_MARK) VALUES (?, ?, ?, ?, ?)";
    private static Logger logger = LogManager.getLogger("edu.iba.sh.dao.mysql");

    @Override
    public List<Professor> getAllProfessors() throws DAOException {
        logger.trace("MySQL.getAllProfessors()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL);
            set = statement.executeQuery();

            List<Professor> list = new ArrayList<Professor>();
            while (set.next()) {
                Professor professor = new Professor();
                professor.setId(Integer.parseInt(set.getString("ID")));
                professor.setFirstName(set.getString("FIRST_NAME"));
                professor.setSecondName(set.getString("SECOND_NAME"));
                professor.setFatherName(set.getString("FATHER_NAME"));
                professor.setBirthDate(set.getString("BIRTH_DATE"));
                professor.setAvgMark(Double.parseDouble(set.getString("AVG_MARK")));
                list.add(professor);
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
    public Professor getProfessorById(Integer id) throws DAOException {
        logger.trace("MySQL.getProfessorById()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID);
            statement.setInt(1, id);
            set = statement.executeQuery();

            if (set.next()) {
                Professor professor = new Professor();
                professor.setId(Integer.parseInt(set.getString("ID")));
                professor.setFirstName(set.getString("FIRST_NAME"));
                professor.setSecondName(set.getString("SECOND_NAME"));
                professor.setFatherName(set.getString("FATHER_NAME"));
                professor.setBirthDate(set.getString("BIRTH_DATE"));
                professor.setAvgMark(Double.parseDouble(set.getString("AVG_MARK")));
                return professor;
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
    public boolean updateProfessor(Integer id, Professor professor) throws DAOException {
        logger.trace("MySQL.updateProfessor()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, professor.getFirstName());
            statement.setString(2, professor.getSecondName());
            statement.setString(3, professor.getFatherName());
            statement.setString(4, professor.getBirthDate());
            statement.setDouble(5, professor.getAvgMark());
            statement.setInt(6, id);
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
    public boolean deleteProfessorById(Integer id) throws DAOException {
        logger.trace("MySQL.deleteProfessorById()");
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
    public void addProfessor(Professor professor) throws DAOException {
        logger.trace("MySQL.addProfessor()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, professor.getFirstName());
            statement.setString(2, professor.getSecondName());
            statement.setString(3, professor.getFatherName());
            statement.setString(4, professor.getBirthDate());
            statement.setDouble(5, professor.getAvgMark());
            statement.executeUpdate();

            ResultSet set = statement.getGeneratedKeys();

            set.next();
            int id = set.getInt(1);
            professor.setId(id);

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
