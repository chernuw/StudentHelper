package edu.iba.sh.dao.db2;

import edu.iba.sh.bean.Mark;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.MarkDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Db2MarkDAOImpl extends Db2AbstractDAO implements MarkDAO {

    private static Logger logger = LogManager.getLogger("edu.iba.sh.dao.db2");

    private static final String GET_ALL = "SELECT ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS FROM LAPUSHA.MARKS";
    private static final String GET_BY_ID = "SELECT ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS FROM LAPUSHA.MARKS WHERE ID = ?";
    private static final String UPDATE = "UPDATE LAPUSHA.MARKS SET STUDY_ID = ?, STUDENT_ID = ?, DATE = ?, PROFESSOR_ID = ? , MARK = ?, COMMENTS = ? WHERE ID = ?";
    private static final String DELETE = "DELETE FROM LAPUSHA.MARKS WHERE ID = ?";
    private static final String INSERT = "INSERT INTO LAPUSHA.MARKS (STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public List<Mark> getAllMarks() throws DAOException {
        logger.trace("DB2.getAllMarks()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL);
            set = statement.executeQuery();

            List<Mark> list = new ArrayList<Mark>();
            while (set.next()) {
                Mark mark = new Mark();
                mark.setId(Integer.parseInt(set.getString("ID")));
                mark.setStudyId(Integer.parseInt(set.getString("STUDY_ID")));
                mark.setStudentId(Integer.parseInt(set.getString("STUDENT_ID")));
                mark.setDate(set.getString("DATE"));
                mark.setProfessorId(Integer.parseInt(set.getString("PROFESSOR_ID")));
                mark.setMark(Integer.parseInt(set.getString("MARK")));
                mark.setComments(set.getString("COMMENTS"));
                list.add(mark);
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
    public Mark getMarkById(Integer id) throws DAOException {
        logger.trace("DB2.getMarkById()");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID);
            statement.setInt(1, id);
            set = statement.executeQuery();

            if (set.next()) {
                Mark mark = new Mark();
                mark.setId(Integer.parseInt(set.getString("ID")));
                mark.setStudyId(Integer.parseInt(set.getString("STUDY_ID")));
                mark.setStudentId(Integer.parseInt(set.getString("STUDENT_ID")));
                mark.setDate(set.getString("DATE"));
                mark.setProfessorId(Integer.parseInt(set.getString("PROFESSOR_ID")));
                mark.setMark(Integer.parseInt(set.getString("MARK")));
                mark.setComments(set.getString("COMMENTS"));
                return mark;
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
    public boolean updateMark(Integer id, Mark mark) throws DAOException {
        logger.trace("DB2.updateMark()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, mark.getStudyId());
            statement.setInt(2, mark.getStudentId());
            statement.setString(3, mark.getDate());
            statement.setInt(4, mark.getProfessorId());
            statement.setInt(5, mark.getMark());
            statement.setString(6, mark.getComments());
            statement.setInt(7, id);
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
    public boolean deleteMarkById(Integer id) throws DAOException {
        logger.trace("DB2.deleteMarkById()");
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
    public void addMark(Mark mark) throws DAOException {
        logger.trace("DB2.addMark()");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, mark.getStudyId());
            statement.setInt(2, mark.getStudentId());
            statement.setString(3, mark.getDate());
            statement.setInt(4, mark.getProfessorId());
            statement.setInt(5, mark.getMark());
            statement.setString(6, mark.getComments());
            statement.executeUpdate();

            ResultSet set = statement.getGeneratedKeys();

            set.next();
            int id = set.getInt(1);
            mark.setId(id);
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
