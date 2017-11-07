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

@WebServlet("/StudieSave")
public class StudieSave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String oldStudie = request.getParameter("oldStudie");
            Studie studie = createStudie(request);

            if (oldStudie.length() == 0) {
                DAOFactory.getStudieDAO().addStudie(studie);
            } else {
                DAOFactory.getStudieDAO().updateStudie(Integer.parseInt(oldStudie), studie);
            }
            request.setAttribute("studie", studie);
            request.getRequestDispatcher("WEB-INF/pages/studies/form.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }

    }

    private Studie createStudie(HttpServletRequest request) {
        Studie studie = new Studie();
        studie.setName(request.getParameter("name"));
        studie.setHours(Integer.parseInt(request.getParameter("hours")));
        studie.setProfessorId(Integer.parseInt(request.getParameter("professorId")));
        studie.setAvgMark(Double.parseDouble(request.getParameter("avgMark")));

        return studie;
    }
}
