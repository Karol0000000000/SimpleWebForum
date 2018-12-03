package example.utils;

import example.dao.UsersDAO;
import example.entities.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/*")
public class FilterLogin implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("UTF-8");
        String login = request.getRemoteUser();

        if(login != null){
            String id_user = (String) request.getSession().getAttribute("id_user");
            if(id_user == null){
                UsersDAO usersDAO = (UsersDAO) request.getAttribute("usersDAO");
                Users user = usersDAO.getAfterLogin(login);

                request.getSession().setAttribute("id_user",String.valueOf(user.getId_user()));
            }
        }
        filterChain.doFilter(request,response);
    }
}
