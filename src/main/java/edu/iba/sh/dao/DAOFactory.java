package edu.iba.sh.dao;

import edu.iba.sh.dao.db2.*;
import edu.iba.sh.dao.mysql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.apache.logging.log4j.web.WebLoggerContextUtils.getServletContext;

public class DAOFactory {

    private static DdType type;

    private enum DdType {
        DB2, MySQL
    }

    private static void initialization() throws IOException {
        Properties properties = new Properties();
        ServletContext context = getServletContext();
        InputStream inputStream = context.getResourceAsStream("/WEB-INF/classes/db.properties");
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
            initialization();
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
            initialization();
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
            initialization();
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
            initialization();
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
            initialization();
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
            initialization();
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

//    TODO: realise recalculate for MySQL

}
