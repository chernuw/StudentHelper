package edu.iba.sh.controller.groups;

import edu.iba.sh.bean.Group;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GroupForm")
public class GroupForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupNumber = request.getParameter("groupNumber");
        Group group;
        try {
            if (groupNumber != null) {
                group = DAOFactory.getGroupDAO().getGroupById(groupNumber);
            } else {
                group = new Group();
            }
            request.setAttribute("group", group);
            request.getRequestDispatcher("WEB-INF/pages/groups/form.jsp").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }
}
