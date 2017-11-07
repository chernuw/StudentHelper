package edu.iba.sh.controller.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "RoleFilter", urlPatterns = {"/GroupList", "/StudentList", "/MarkList", "/ProfessorList", "/StudieList", "/UserList",
        "/GroupForm", "/StudentForm", "/MarkForm", "/ProfessorForm", "/StudieForm", "/UserForm"})
public class RoleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
        }
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String uri = httpRequest.getRequestURI();

        HttpSession session = httpRequest.getSession();

        boolean isAdmOrProf = session.getAttribute("userRoleLogin").toString().equals("ADMIN")
                | session.getAttribute("userRoleLogin").toString().equals("PROFESSOR");
        boolean isMarkPage = (!uri.endsWith("/MarkList") | !uri.endsWith("/MarkForm"));

        if (isAdmOrProf) {
            if (session.getAttribute("userRoleLogin").toString().equals("PROFESSOR")
                    & !isMarkPage) {
                httpResponse.sendRedirect("AccessDenied");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            httpResponse.sendRedirect("AccessDenied");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
