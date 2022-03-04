package crud_board.servlets;

import crud_board.controllers.*;
import crud_board.dao.MySqlPeedDao;
import crud_board.vo.Peed;
import crud_board.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
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
        MySqlPeedDao peedDao = (MySqlPeedDao) sc.getAttribute("peedDao");

        try {
            Controller pageController;

            if (servletPath.equals("/auth/login.do")) {
                pageController = new LogInController();
            } else if (servletPath.equals("/peed/main.do")) {
                pageController = new PeedListController().setPeedDao(peedDao);
            } else if (servletPath.equals("/peed/content.do")) {
                if (request.getParameter("no") != null) {
                    model.put("no", Integer.parseInt(request.getParameter("no")));
                    pageController = new PeedContentController().setPeedDao(peedDao);
                } else {
                    throw new ServletException();
                }
            } else if (servletPath.equals("/peed/add.do")) {
                User user;
                if(session.getAttribute("user") != null) {
                    user = (User) session.getAttribute("user");
                } else {
                    user = new User().setName("anonymous");
                }

                if (request.getParameter("title") != null) {
                    Peed peed = new Peed()
                            .setTitle(request.getParameter("title"))
                            .setContent(request.getParameter("content"))
                            .setWriter(user.getName());
                    model.put("peed", peed);
                }

                pageController = new PeedAddController().setPeedDao(peedDao);
            } else if (servletPath.equals("/peed/edit.do")) {
                int no = Integer.parseInt(request.getParameter("no"));

                if (request.getParameter("title") == null) {
                    model.put("no", no);
                } else {
                    Peed peed = new Peed()
                            .setNo(no)
                            .setTitle(request.getParameter("title"))
                            .setContent(request.getParameter("content"));
                    model.put("editPeed", peed);
                }

                pageController = new PeedEditController().setPeedDao(peedDao);
            } else if (servletPath.equals("/peed/delete.do")) {
                if (request.getParameter("no") != null) {
                    model.put("no", Integer.parseInt(request.getParameter("no")));
                    pageController = new PeedDeleteController().setPeedDao(peedDao);
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
