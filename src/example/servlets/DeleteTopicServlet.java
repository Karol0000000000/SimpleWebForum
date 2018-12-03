package example.servlets;

import example.dao.RegistrationsDAO;
import example.dao.TopicsDAO;
import example.entities.Topics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteTopicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_topic = req.getParameter("id_topic");
        TopicsDAO topicsDAO = (TopicsDAO) req.getAttribute("topicsDAO");
        Topics topic = topicsDAO.getTopic(Integer.parseInt(id_topic));
        req.setAttribute("topic",topic);
        req.getRequestDispatcher("WEB-INF/views/delete.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id_topic = req.getParameter("id_topic");
        String password = req.getParameter("password");

        TopicsDAO topicsDAO = (TopicsDAO) req.getAttribute("topicsDAO");
        Topics topic = topicsDAO.getTopic(Integer.parseInt(id_topic));

        if(password.equals(topic.getUser().getPassword())){

            RegistrationsDAO registrationsDAO = (RegistrationsDAO) req.getAttribute("registrationsDAO");
            if(!registrationsDAO.removeRegistrationsOfTopic(Integer.parseInt(id_topic))){
                req.setAttribute("error", "Error: registrations wasn't deleted");
                doGet(req,resp);
            }
            if(!topicsDAO.removeTopic(Integer.parseInt(id_topic))){
                req.setAttribute("error", "Error: topic wasn't deleted");
                doGet(req,resp);
            }

            resp.sendRedirect(req.getContextPath() +"/index");
        }else{
            req.setAttribute("error","Password is incorrect");
            doGet(req,resp);
        }
    }
}
