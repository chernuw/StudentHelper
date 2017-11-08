package edu.iba.sh.controller.users;

import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String oldUser = request.getParameter("oldUser");
            DAOFactory.getUserDAO().deleteUserById(oldUser);
            request.getRequestDispatcher("/UserList").forward(request, response);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }
}
