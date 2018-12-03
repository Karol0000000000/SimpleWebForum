package example.utils;

import example.dao.RegistrationsDAO;
import example.dao.SimpleDAO;
import example.dao.TopicsDAO;
import example.dao.UsersDAO;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitiatorDB implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        UsersDAO usersDAO = new UsersDAO(DBConfig.getEntityManager());
        TopicsDAO topicsDAO = new TopicsDAO(DBConfig.getEntityManager());
        RegistrationsDAO registrationsDAO = new RegistrationsDAO(DBConfig.getEntityManager());
        SimpleDAO simpleDAO = new SimpleDAO(DBConfig.getEntityManager());

        ServletRequest servletRequest = sre.getServletRequest();
        servletRequest.setAttribute("usersDAO",usersDAO);
        servletRequest.setAttribute("topicsDAO",topicsDAO);
        servletRequest.setAttribute("registrationsDAO",registrationsDAO);
        servletRequest.setAttribute("simpleDAO",simpleDAO);
    }
}
