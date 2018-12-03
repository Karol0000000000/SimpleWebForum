package example.servlets;

import example.dao.RegistrationsDAO;
import example.dao.TopicsDAO;
import example.entities.Registrations;
import example.entities.Topics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(value = "/topics")
public class TopicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String stringId = req.getParameter("id");
        if(stringId != null){
            int id = Integer.parseInt(stringId);
            TopicsDAO topicDAO = (TopicsDAO) req.getAttribute("topicsDAO");
            Topics topic = topicDAO.getTopic(id);
            req.setAttribute("topic",topic);
            req.getRequestDispatcher("WEB-INF/views/topic.jsp").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = req.getParameter("content");
        String id = req.getParameter("id");

        if(content !=null && id != null){

            int topic_id = Integer.parseInt(id);
            RegistrationsDAO registrationDAO = (RegistrationsDAO) req.getAttribute("registrationsDAO");
            Registrations registration = new Registrations();
            registration.setContent(content);
            registration.setDate(new Timestamp(new Date().getTime()));
            registration.setId_topic(topic_id);
            String id_user = (String) req.getSession().getAttribute("id_user");
            registration.setId_user(Integer.parseInt(id_user));

            registrationDAO.addRegistration(registration);
        }
        resp.sendRedirect(req.getContextPath()+"/topics?id="+id);
    }
}
