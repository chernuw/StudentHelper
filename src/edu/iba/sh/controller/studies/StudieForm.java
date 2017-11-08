package edu.iba.sh.controller.studies;

import edu.iba.sh.bean.Professor;
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

@WebServlet("/StudieForm")
public class StudieForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studieId = request.getParameter("id");
        Studie studie;
        try {
            if (studieId != null) {
                studie = DAOFactory.getStudieDAO().getStudieById(Integer.parseInt(studieId));
            } else {
                studie = new Studie();
            }

            List<Professor> professors = DAOFactory.getProfessorDAO().getAllProfessors();
            request.setAttribute("professors", professors);

            request.setAttribute("studie", studie);
            request.getRequestDispatcher("WEB-INF/pages/studies/form.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }
}
