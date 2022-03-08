package crud_board.servlets;

import crud_board.controllers.*;
import crud_board.dao.MySqlFeedDao;
import crud_board.dao.MySqlUserDao;
import crud_board.vo.Feed;
import crud_board.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String servletPath = request.getServletPath();
        HashMap<String, Object> model = new HashMap<>();

        HttpSession session = request.getSession();

        ServletContext sc = request.getServletContext();
        MySqlFeedDao feedDao = (MySqlFeedDao) sc.getAttribute("peedDao");
        MySqlUserDao userDao = (MySqlUserDao) sc.getAttribute("userDao");

        try {
            Controller pageController;

            if (servletPath.equals("/auth/login.do")) {
                if (request.getParameter("anonymous") != null) {
                    model.put("anonymous", request.getParameter("anonymous"));
                    model.put("session", session);
                } else if (request.getParameter("id") != null) {
                    model.put("id", request.getParameter("id"));
                    model.put("password", request.getParameter("password"));
                    model.put("session", session);
                }
                pageController = new LogInController().setUserDao(userDao);
            } else if (servletPath.equals("/auth/logout.do")) {
                model.put("session", session);
                pageController = new LogOutController();
            } else if (servletPath.equals("/auth/join.do")) {
                if (request.getParameter("name") != null) {
                    User user = new User()
                            .setName(request.getParameter("name"))
                            .setId(request.getParameter("id"))
                            .setPassword(request.getParameter("password"));
                    model.put("newUser", user);
                }
                pageController = new JoinController().setUserDao(userDao);
            } else if (servletPath.equals("/feed/main.do")) {
                model.put("session", session);
                pageController = new FeedListController().setFeedDao(feedDao);
            } else if (servletPath.equals("/feed/content.do")) {
                if (request.getParameter("no") != null) {
                    model.put("no", Integer.parseInt(request.getParameter("no")));
                    pageController = new FeedContentController().setFeedDao(feedDao);
                } else {
                    throw new ServletException();
                }
            } else if (servletPath.equals("/feed/add.do")) {

                if (request.getParameter("title") != null) {
                    Feed feed = new Feed()
                            .setTitle(request.getParameter("title"))
                            .setContent(request.getParameter("content"))
                            .setWriter((String) session.getAttribute("loginUser"));
                    model.put("feed", feed);
                }

                pageController = new FeedAddController().setFeedDao(feedDao);
            } else if (servletPath.equals("/feed/edit.do")) {
                int no = Integer.parseInt(request.getParameter("no"));

                if (request.getParameter("title") == null) {
                    model.put("no", no);
                } else {
                    Feed feed = new Feed()
                            .setNo(no)
                            .setTitle(request.getParameter("title"))
                            .setContent(request.getParameter("content"));
                    model.put("editFeed", feed);
                }

                pageController = new FeedEditController().setFeedDao(feedDao);
            } else if (servletPath.equals("/feed/delete.do")) {
                if (request.getParameter("no") != null) {
                    model.put("no", Integer.parseInt(request.getParameter("no")));
                    pageController = new FeedDeleteController().setFeedDao(feedDao);
                } else {
                    throw new ServletException();
                }
            }
            else {
                // TODO: error handling
                pageController = new LogInController();
            }

            String viewUrl = pageController.execute(model);

            for (String key : model.keySet()) {
                request.setAttribute(key, model.get(key));
            }

            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            } else {
                RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
                rd.include(request, response);
            }
        } catch (Exception e) {

        }
    }
}
