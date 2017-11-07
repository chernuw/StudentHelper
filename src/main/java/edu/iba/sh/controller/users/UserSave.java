package edu.iba.sh.controller.users;

import edu.iba.sh.bean.User;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UserSave
 */
@WebServlet("/UserSave")
public class UserSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String oldUser = request.getParameter("oldUser");
			User user = createUser(request);

			if (oldUser.length() == 0) {
				DAOFactory.getUserDAO().addUser(user);
			} else {
				DAOFactory.getUserDAO().updateUser(oldUser, user);
			}
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/pages/users/form.jsp")
					.forward(request, response);
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}

	private User createUser(HttpServletRequest request) {
		User user = new User();

		user.setUser(request.getParameter("user"));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));

		return user;
	}

}
