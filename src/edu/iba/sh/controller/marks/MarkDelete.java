package edu.iba.sh.controller.marks;

import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/MarkDelete")
public class MarkDelete extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer oldMark = Integer.parseInt(request.getParameter("oldMark"));
            DAOFactory.getMarkDAO().deleteMarkById(oldMark);
            request.getRequestDispatcher("/MarkList").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }
}
