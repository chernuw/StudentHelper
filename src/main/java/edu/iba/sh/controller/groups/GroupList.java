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
import java.util.List;

@WebServlet("/GroupList")
public class GroupList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Group> groups = DAOFactory.getGroupDAO().getAllGroups();
            request.setAttribute("groups", groups);
            request.getRequestDispatcher("WEB-INF/pages/groups/list.jsp").forward(request,response);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
