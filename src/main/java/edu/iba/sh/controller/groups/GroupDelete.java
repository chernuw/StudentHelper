package edu.iba.sh.controller.groups;

import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GroupDelete")
public class GroupDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String oldGroupNumber = request.getParameter("oldGroupNumber");
            DAOFactory.getGroupDAO().deleteGroupById(oldGroupNumber);
            request.getRequestDispatcher("/GroupList").forward(request, response);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
