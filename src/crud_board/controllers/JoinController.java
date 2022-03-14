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

            if (newUser.getId() == null) {
                return "/auth/JoinForm.jsp";
            } else {
                if (userDao.existId(newUser.getId())) {
                    // TODO alert duplicate issue
                    return "redirect:join.do";
                } else {
                    model.put("id", newUser.getId());
                    model.put("password", newUser.getPassword());
                    return "/auth/JoinForm2.jsp";
                }
            }

        } else {
            if (userDao.existName(newUser.getName())) {
                // TODO alert duplicate issue
                return "redirect:join.do";
            } else {
                userDao.insert(newUser);
                return "redirect:login.do";
            }

        }
    }
}
