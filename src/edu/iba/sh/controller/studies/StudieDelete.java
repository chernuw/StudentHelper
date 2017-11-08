package edu.iba.sh.controller.studies;

import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudieDelete")
public class StudieDelete extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer oldStudie = Integer.parseInt(request.getParameter("oldStudie"));
            DAOFactory.getStudieDAO().deleteStudieById(oldStudie);
            request.getRequestDispatcher("/StudieList").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }
}
