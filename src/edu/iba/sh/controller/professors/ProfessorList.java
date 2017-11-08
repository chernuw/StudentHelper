package edu.iba.sh.controller.professors;

import edu.iba.sh.bean.Professor;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProfessorList")
public class ProfessorList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Professor> professors = DAOFactory.getProfessorDAO().getAllProfessors();
            request.setAttribute("professors", professors);
            request.getRequestDispatcher("WEB-INF/pages/professors/list.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }
}
