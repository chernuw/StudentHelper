package edu.iba.sh.dao.mysql;

import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.StudentDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlStudentDAOImpl extends MysqlAbstractDAO implements StudentDAO {

	private static Logger logger = LogManager.getLogger("edu.iba.sh.dao.mysql");

	private static final String GET_ALL = "SELECT ID, FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP_NUMBER FROM LAPUSHA.STUDENTS";
	private static final String GET_BY_ID = "SELECT ID, FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP_NUMBER FROM LAPUSHA.STUDENTS WHERE ID = ?";
	private static final String UPDATE = "UPDATE LAPUSHA.STUDENTS SET FIRST_NAME = ?, SECOND_NAME = ?, AVG_MARK = ?, GROUP_NUMBER = ? WHERE ID = ?";
	private static final String DELETE = "DELETE FROM LAPUSHA.STUDENTS WHERE ID = ?";
	private static final String INSERT = "INSERT INTO LAPUSHA.STUDENTS (FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP_NUMBER) VALUES (?, ?, ?, ?)";

	@Override
	public List<Student> getAllStudents() throws DAOException {
		logger.trace("MySQL.getAllStudents()");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(GET_ALL);
			set = statement.executeQuery();

			List<Student> list = new ArrayList<Student>();
			while (set.next()) {
				Student student = new Student();
				student.setId(Integer.parseInt(set.getString("ID")));
				student.setFirstName(set.getString("FIRST_NAME"));
				student.setSecondName(set.getString("SECOND_NAME"));
				student.setAvgMark(Double.parseDouble(set.getString("AVG_MARK")));
				student.setGroupNumber(set.getString("GROUP_NUMBER"));
				list.add(student);
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
	public Student getStudentById(Integer id) throws DAOException {
		logger.trace("MySQL.getStudentById()");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			set = statement.executeQuery();

			if (set.next()) {
				Student student = new Student();
				student.setId(Integer.parseInt(set.getString("ID")));
				student.setFirstName(set.getString("FIRST_NAME"));
				student.setSecondName(set.getString("SECOND_NAME"));
				student.setAvgMark(Double.parseDouble(set.getString("AVG_MARK")));
				student.setGroupNumber(set.getString("GROUP_NUMBER"));
				return student;
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
	public boolean updateStudent(Integer id, Student student) throws DAOException {
		logger.trace("MySQL.updateStudent()");
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(UPDATE);
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getSecondName());
			statement.setDouble(3, student.getAvgMark());
			statement.setString(4, student.getGroupNumber());
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
	public boolean deleteStudentById(Integer id) throws DAOException {
		logger.trace("MySQL.deleteStudentById()");
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
	public void addStudent(Student student) throws DAOException {
		logger.trace("MySQL.addStudent()");
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getSecondName());
			statement.setDouble(3, student.getAvgMark());
			statement.setString(4, student.getGroupNumber());
			statement.executeUpdate();

			ResultSet set = statement.getGeneratedKeys();
			
			set.next();
			int id = set.getInt(1);
			student.setId(id);

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
