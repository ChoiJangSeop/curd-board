package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlUserDao;
import crud_board.vo.User;

import java.util.Map;

public class JoinController implements Controller, DataBinding {

    MySqlUserDao userDao;

    public JoinController setUserDao(MySqlUserDao userDao) {
        this.userDao = userDao;
        return this;
    }

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
          "newUser", crud_board.vo.User.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        User newUser = (User) model.get("newUser");

        if (newUser.getName() == null) {
            return "/auth/JoinForm.jsp";
        } else {
            userDao.insert(newUser);
            return "redirect:login.do";
        }
    }
}
