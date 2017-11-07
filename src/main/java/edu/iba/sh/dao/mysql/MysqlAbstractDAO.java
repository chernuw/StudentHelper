package edu.iba.sh.dao.mysql;

import edu.iba.sh.dao.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class MysqlAbstractDAO {

    private static  final String RESOURCE_NAME = "jdbc:mysql://localhost:3306/LAPUSHA?useSSL=false";

    protected final Connection getConnection() throws DAOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(RESOURCE_NAME, "root", "1234567890qwE");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
