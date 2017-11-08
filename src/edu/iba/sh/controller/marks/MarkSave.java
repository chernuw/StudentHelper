package edu.iba.sh.controller.marks;

import edu.iba.sh.bean.Mark;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("/MarkSave")
public class MarkSave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Mark mark = createMark(request);
            DAOFactory.getMarkDAO().addMark(mark);
            request.setAttribute("mark", mark);
            request.getRequestDispatcher("WEB-INF/pages/marks/form.jsp").forward(request, response);
        } catch (ParseException e) {
            throw new ServletException(e);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }

    private Mark createMark(HttpServletRequest request) throws ParseException {
        Mark mark = new Mark();

        mark.setStudyId(Integer.parseInt(request.getParameter("studieId")));
        mark.setStudentId(Integer.parseInt(request.getParameter("studentId")));
        mark.setDate(request.getParameter("date"));
        mark.setProfessorId(Integer.parseInt(request.getParameter("professorId")));
        mark.setMark(Integer.parseInt(request.getParameter("markMark")));
        mark.setComments(request.getParameter("comments"));

        return mark;
    }
}
