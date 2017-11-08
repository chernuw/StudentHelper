package edu.iba.sh.controller.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticateFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
        }
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String uri = httpRequest.getRequestURI();

        HttpSession session = httpRequest.getSession();


        if (session.getAttribute("userLogin") != null || uri.matches(".+\\..+")
                || uri.endsWith("Authenticate") || uri.endsWith("Login")) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect("Login");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
