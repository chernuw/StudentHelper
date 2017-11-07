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

@WebServlet("/ProfessorForm")
public class ProfessorForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String professorId = request.getParameter("id");
        Professor professor;
        try {
            if (professorId != null) {
                professor = DAOFactory.getProfessorDAO().getProfessorById(Integer.parseInt(professorId));
            } else {
                professor = new Professor();
            }

            request.setAttribute("professor", professor);
            request.getRequestDispatcher("WEB-INF/pages/professors/form.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }
}
