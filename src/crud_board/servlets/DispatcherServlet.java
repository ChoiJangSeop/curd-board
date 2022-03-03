package crud_board.servlets;

import crud_board.controllers.Controller;
import crud_board.controllers.LogInController;
import crud_board.controllers.PeedContentController;
import crud_board.controllers.PeedListController;
import crud_board.dao.MySqlPeedDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html; charset=UTF-8");
        String servletPath = request.getServletPath();
        HashMap<String, Object> model = new HashMap<>();

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
