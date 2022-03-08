package crud_board.controllers;

import crud_board.dao.MySqlUserDao;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class LogInController implements Controller {

    MySqlUserDao userDao;

    public LogInController setUserDao(MySqlUserDao userDao) {
        this.userDao = userDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        if (model.get("anonymous") != null) {
            HttpSession session = (HttpSession) model.get("session");
            session.setAttribute("loginUser", "익명");
            return "redirect:../feed/main.do";
        }

        if (model.get("id") == null) {
            return "/auth/LoginForm.jsp";
        } else {
            String id = (String) model.get("id");
            String password = (String) model.get("password");
            boolean flag = userDao.exist(id, password);

            if (flag) {
                // TODO register user to HttpSession
                HttpSession session = (HttpSession) model.get("session");
                session.setAttribute("loginUser", id);
                return "redirect:../feed/main.do";
            } else {
                return "redirect:login.do";
            }
        }
    }
}
