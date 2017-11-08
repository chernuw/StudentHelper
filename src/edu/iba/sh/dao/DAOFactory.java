package edu.iba.sh.dao;

import edu.iba.sh.dao.db2.*;
import edu.iba.sh.dao.mysql.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAOFactory {

    private static DdType type;

    private static void checkDB() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("db.properties");
        properties.load(inputStream);
        String db = properties.getProperty("db");
        if (db.equals("MySQL")) {
            type = DdType.MySQL;
        } else {
            type = DdType.DB2;
        }
    }

    public static GroupDAO getGroupDAO() throws ServletException {
        try {
            checkDB();
        } catch (IOException e) {
            throw new ServletException(e);
        }
        switch (type) {
            case DB2:
                return new Db2GroupDAOImpl();
            case MySQL:
                return new MysqlGroupDAOImpl();
            default:
                return null;
        }
    }

    public static MarkDAO getMarkDAO() throws ServletException {
        try {
            checkDB();
        } catch (IOException e) {
            throw new ServletException(e);
        }
        switch (type) {
            case DB2:
                return new Db2MarkDAOImpl();
            case MySQL:
                return new MysqlMarkDAOImpl();
            default:
                return null;
        }
    }

    public static ProfessorDAO getProfessorDAO() throws ServletException {
        try {
            checkDB();
        } catch (IOException e) {
            throw new ServletException(e);
        }
        switch (type) {
            case DB2:
                return new Db2ProfessorDAOImpl();
            case MySQL:
                return new MysqlProfessorDAOImpl();
            default:
                return null;
        }
    }

    public static StudentDAO getStudentDAO() throws ServletException {
        try {
            checkDB();
        } catch (IOException e) {
            throw new ServletException(e);
        }
        switch (type) {
            case DB2:
                return new Db2StudentDAOImpl();
            case MySQL:
                return new MysqlStudentDAOImpl();
            default:
                return null;
        }
    }

    public static StudieDAO getStudieDAO() throws ServletException {
        try {
            checkDB();
        } catch (IOException e) {
            throw new ServletException(e);
        }
        switch (type) {
            case DB2:
                return new Db2StudieDAOImpl();
            case MySQL:
                return new MysqlStudieDAOImpl();
            default:
                return null;
        }
    }

    public static UserDAO getUserDAO() throws ServletException {
        try {
            checkDB();
        } catch (IOException e) {
            throw new ServletException(e);
        }
        switch (type) {
            case DB2:
                return new Db2UserDAOImpl();
            case MySQL:
                return new MysqlUserDAOImpl();
            default:
                return null;
        }
    }

    private enum DdType {
        DB2, MySQL
    }

//    TODO: realise recalculate for MySQL

}
