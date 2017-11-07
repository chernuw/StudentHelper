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

@WebServlet("/GroupSave")
public class GroupSave extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String oldGroupNumber = request.getParameter("oldGroupNumber");
            Group group = createGroup(request);

            if (oldGroupNumber.length() == 0) {
                DAOFactory.getGroupDAO().addGroup(group);
            } else{
                DAOFactory.getGroupDAO().updateGroup(oldGroupNumber,group);
            }
            request.setAttribute("group", group);
            request.getRequestDispatcher("WEB-INF/pages/groups/form.jsp").forward(request,response);
        } catch (DAOException e){
            throw new ServletException(e);
        }
    }


    private Group createGroup(HttpServletRequest request) {
        Group group = new Group();

        group.setGroupNumber(request.getParameter("number"));
        group.setAvgMark(Double.parseDouble(request.getParameter("avgMark")));

        return group;
    }
}
