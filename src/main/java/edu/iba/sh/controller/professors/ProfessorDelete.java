package edu.iba.sh.controller.professors;

import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProfessorDelete")
public class ProfessorDelete extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Integer oldProfessor = Integer.parseInt(request.getParameter("oldProfessor"));
            DAOFactory.getProfessorDAO().deleteProfessorById(oldProfessor);
            request.getRequestDispatcher("/ProfessorList").forward(request,response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }
}
