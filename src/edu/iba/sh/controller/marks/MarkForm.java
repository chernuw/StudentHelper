package edu.iba.sh.controller.marks;

import edu.iba.sh.bean.Mark;
import edu.iba.sh.bean.Professor;
import edu.iba.sh.bean.Student;
import edu.iba.sh.bean.Studie;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MarkForm")
public class MarkForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Mark mark;
            mark = new Mark();
            request.setAttribute("mark", mark);

            List<Studie> studies = DAOFactory.getStudieDAO().getAllStudies();
            List<Student> students = DAOFactory.getStudentDAO().getAllStudents();
            List<Professor> professors = DAOFactory.getProfessorDAO().getAllProfessors();

            request.setAttribute("studies", studies);
            request.setAttribute("students", students);
            request.setAttribute("professors", professors);

            request.getRequestDispatcher("WEB-INF/pages/marks/form.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
