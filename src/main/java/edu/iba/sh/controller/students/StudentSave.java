package edu.iba.sh.controller.students;

import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentSave")
public class StudentSave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String oldStudent = request.getParameter("oldStudent");
            Student student = createStudent(request);

            if (oldStudent.length() == 0) {
                DAOFactory.getStudentDAO().addStudent(student);
            } else {
                DAOFactory.getStudentDAO().updateStudent(Integer.parseInt(oldStudent), student);
            }
            request.setAttribute("student", student);
            request.getRequestDispatcher("WEB-INF/pages/students/form.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }

    private Student createStudent(HttpServletRequest request) {
        Student student = new Student();

        student.setFirstName(request.getParameter("firstName"));
        student.setSecondName(request.getParameter("secondName"));
        student.setAvgMark(Double.parseDouble(request.getParameter("avgMark")));
        student.setGroupNumber(request.getParameter("groupNumber"));

        return student;
    }

}
