package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlUserDao;
import crud_board.vo.User;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class LogInController implements Controller, DataBinding {

    MySqlUserDao userDao;

    public LogInController setUserDao(MySqlUserDao userDao) {
        this.userDao = userDao;
        return this;
    }

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
                "anonymous", String.class,
                "id", String.class,
                "password", String.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        String anonymous = (String) model.get("anonymous");
        String id = (String) model.get("id");
        String password = (String) model.get("password");

        if (anonymous.equals("true")) {
            HttpSession session = (HttpSession) model.get("session");
            session.setAttribute("loginUser", "익명");
            return "redirect:../feed/main.do";
        }

        // TODO how to check id is null?
        if (id.equals("null")) {
            return "/auth/LoginForm.jsp";
        } else {
            int no = userDao.exist(id, password);

            if (no != -1) {
                HttpSession session = (HttpSession) model.get("session");
                User loginUser = userDao.selectOne(no);

                session.setAttribute("loginUser", loginUser.getName());
                return "redirect:../feed/main.do";
            } else {
                return "redirect:login.do";
            }
        }
    }
}
