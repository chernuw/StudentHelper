package edu.iba.sh.controller.studies;

import edu.iba.sh.bean.Studie;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudieList")
public class StudieList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Studie> studies = DAOFactory.getStudieDAO().getAllStudies();
            request.setAttribute("studies", studies);
            request.getRequestDispatcher("WEB-INF/pages/studies/list.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }
}
