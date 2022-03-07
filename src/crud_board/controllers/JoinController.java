package crud_board.controllers;

import crud_board.dao.MySqlUserDao;
import crud_board.vo.User;

import java.util.Map;

public class JoinController implements Controller {

    MySqlUserDao userDao;

    public JoinController setUserDao(MySqlUserDao userDao) {
        this.userDao = userDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        if (model.get("newUser") == null) {
            return "/auth/JoinForm.jsp";
        } else {
            User newUser = (User) model.get("newUser");
            userDao.insert(newUser);
            return "redirect:login.do";
        }
    }
}
