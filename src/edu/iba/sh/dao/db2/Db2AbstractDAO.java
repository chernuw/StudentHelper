package edu.iba.sh.dao.db2;

import edu.iba.sh.dao.DAOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Db2AbstractDAO {

    private static final String RESOURCE_NAME = "jdbc/StudentHelperDS";

    protected final Connection getConnection() throws DAOException {
        try {
            InitialContext context = new InitialContext();
            DataSource source = (DataSource) context.lookup(RESOURCE_NAME);
            return source.getConnection();
        } catch (NamingException e) {
            throw new DAOException(e);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

}
