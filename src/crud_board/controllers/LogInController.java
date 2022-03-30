package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlUserDao;
import crud_board.vo.User;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
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

        if (anonymous != null && anonymous.equals("true")) {
            HttpSession session = (HttpSession) model.get("session");
            session.setAttribute("loginUser", "익명");

            session.setAttribute("searchLog", new ArrayList<String>());

            return "redirect:../feed/main.do";
        }

        if (id == null) {
            return "/auth/LoginForm.jsp";
        } else {
            if (id.equals("") || password.equals("")) {
                model.put("alert", "아이디와 비번을 모두 입력해주세요");
                return "/auth/LoginForm.jsp";
            }

            int no = userDao.exist(id, password);

            if (no != -1) {
                HttpSession session = (HttpSession) model.get("session");
                User loginUser = userDao.selectOne(no);

                session.setAttribute("loginUser", loginUser.getName());
                session.setAttribute("searchLog", new ArrayList<String>());
                return "redirect:../feed/main.do";
            } else {
                model.put("alert", "아이디 또는 비밀번호가 일치하지 않습니다");
                return "/auth/LoginForm.jsp";
            }
        }
    }
}
