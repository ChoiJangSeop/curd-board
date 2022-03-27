package crud_board.servlets;

import crud_board.bind.DataBinding;
import crud_board.bind.ServletRequestDataBinder;
import crud_board.context.ApplicationContext;
import crud_board.controllers.*;
import crud_board.dao.MySqlFeedDao;
import crud_board.dao.MySqlUserDao;
import crud_board.listener.ContextLoaderListener;
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
import javax.swing.plaf.synth.ColorType;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String servletPath = request.getServletPath();

        try {
            HashMap<String, Object> model = new HashMap<>();
            model.put("session", session);

            ApplicationContext ctx = ContextLoaderListener.getApplicationContext();

            Controller pageController = (Controller) ctx.getBean(servletPath);

            if (pageController instanceof DataBinding) {
                prepareRequestData(request, model, (DataBinding) pageController);
            }

            String viewUrl = "";

            if (!servletPath.startsWith("/auth") && session.getAttribute("loginUser") == null) {
                viewUrl = "redirect:../auth/login.do";
            } else if (pageController != null) {
                viewUrl = pageController.execute(model);
            }



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
            throw new ServletException(e);
        }
    }

    private void prepareRequestData(
            HttpServletRequest request, HashMap<String, Object> model, DataBinding dataBinding) throws Exception {
        Object[] dataBinders = dataBinding.getDataBinders();

        String name = null;
        Class<?> type = null;
        Object obj = null;

        for (int i=0; i<dataBinders.length; i+=2) {
            name = (String) dataBinders[i];
            type = (Class<?>) dataBinders[i+1];
            obj = ServletRequestDataBinder.bind(request, type, name);
            model.put(name, obj);
        }
    }
}
