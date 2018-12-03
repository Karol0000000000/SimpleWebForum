package example.servlets;

import example.dao.TopicsDAO;
import example.entities.Topics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(value = "/newTopic")
public class NewTopicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/newTopic.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = req.getParameter("content");
        String title = req.getParameter("title");

        if ("".equals(title) || title.isEmpty() || "".equals(content) || content.isEmpty() || title.trim().equals("") || content.trim().equals("")) {
            req.setAttribute("error", "Title or content is empty");
            doGet(req, resp);
        }
        else {
            Topics topic = new Topics();
            topic.setContent(content);
            topic.setDate(new Timestamp(new Date().getTime()));
            topic.setTitle(title);
            String id_user = (String) req.getSession().getAttribute("id_user");
            topic.setId_user(Integer.parseInt(id_user));

            TopicsDAO topicsDAO = (TopicsDAO) req.getAttribute("topicsDAO");
            if (topicsDAO.addTopic(topic)) {
                resp.sendRedirect(req.getContextPath() + "/topics?id=" + topic.getId_topic());
            }
        }
    }
}
