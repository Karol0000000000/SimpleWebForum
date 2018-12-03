package example.servlets;

import example.dao.UsersDAO;
import example.entities.Users;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/registrations.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        if(login != null && !login.equals("") && password1 != null && !password1.equals("") && password1.equals(password2)){

            UsersDAO usersDAO = (UsersDAO) req.getAttribute("usersDAO");

            try {
                usersDAO.getAfterLogin(login);
                req.setAttribute("error","User with this login has existed in database");
                doGet(req,resp);
            }catch (NoResultException e){
                Users user = new Users();
                user.setLogin(login);
                user.setPassword(password1);
                if(usersDAO.addUser(user)){
                    resp.sendRedirect(req.getContextPath()+"/index");
                }else{
                 req.setAttribute("error","Error with database");
                }
            }
        }else {
            req.setAttribute("error","Login or password is empty or password1 not equals password2");
            doGet(req,resp);
        }
}
}
