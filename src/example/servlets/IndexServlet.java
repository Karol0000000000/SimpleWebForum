package example.servlets;

import example.dao.TopicsDAO;
import example.entities.Topics;
import example.entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TopicsDAO topicsDAO = (TopicsDAO) req.getAttribute("topicsDAO");
        List<Topics> allTopics = topicsDAO.getAllTopics();
        req.setAttribute("allTopics",allTopics);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
