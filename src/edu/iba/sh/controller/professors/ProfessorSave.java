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

@WebServlet("/ProfessorSave")
public class ProfessorSave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String oldProfessor = request.getParameter("oldProfessor");
            Professor professor = createProfessor(request);

            if (oldProfessor.length() == 0) {
                DAOFactory.getProfessorDAO().addProfessor(professor);
            } else {
                DAOFactory.getProfessorDAO().updateProfessor(Integer.parseInt(oldProfessor), professor);
            }
            request.setAttribute("professor", professor);
            request.getRequestDispatcher("WEB-INF/pages/professors/form.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }

    private Professor createProfessor(HttpServletRequest request) {
        Professor professor = new Professor();

        professor.setFirstName(request.getParameter("firstName"));
        professor.setSecondName(request.getParameter("secondName"));
        professor.setFatherName(request.getParameter("fatherName"));
        professor.setBirthDate(request.getParameter("birthDate"));
        professor.setAvgMark(Double.parseDouble(request.getParameter("avgMark")));

        return professor;
    }
}
