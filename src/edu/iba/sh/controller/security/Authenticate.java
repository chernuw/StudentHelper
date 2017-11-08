package edu.iba.sh.controller.security;

import edu.iba.sh.bean.User;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userId = request.getParameter("user");
            String password = request.getParameter("password");

            User user = DAOFactory.getUserDAO().getUserByIdAndPassword(userId, password);

            if (user == null) {
                request.setAttribute("message", "Incorrect user or password");
                request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("userLogin", user);
                request.getSession().setAttribute("userRoleLogin", user.getRole());
                response.sendRedirect("Welcome");
            }
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }

}
