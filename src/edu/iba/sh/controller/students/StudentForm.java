package edu.iba.sh.controller.students;

import edu.iba.sh.bean.Group;
import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentForm")
public class StudentForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("id");
        Student student;
        try {
            if (studentId != null) {
                student = DAOFactory.getStudentDAO().getStudentById(Integer.parseInt(studentId));
            } else {
                student = new Student();
            }

            List<Group> groups = DAOFactory.getGroupDAO().getAllGroups();
            request.setAttribute("groups", groups);

            request.setAttribute("student", student);
            request.getRequestDispatcher("WEB-INF/pages/students/form.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }

    }
}
