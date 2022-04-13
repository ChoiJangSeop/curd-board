package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlUserDao;
import crud_board.service.UserService;
import crud_board.vo.User;

import java.util.Map;

public class JoinController implements Controller, DataBinding {

    //MySqlUserDao userDao;
    UserService userService;

    public JoinController setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }
/*
    public JoinController setUserDao(MySqlUserDao userDao) {
        this.userDao = userDao;
        return this;
    }
*/
    @Override
    public Object[] getDataBinders() {
        return new Object[] {
                "newUser", crud_board.vo.User.class,
                "passwordCheck", String.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        User newUser = (User) model.get("newUser");
        String passwordCheck = (String) model.get("passwordCheck");

        // rendering first form (input id/pwd)
        if (newUser.getName() == null) {

            // enter join form
            if (newUser.getId() == null) {
                return "/auth/JoinForm.jsp";
            }
            // alert some input is blank
            if (newUser.getId().equals("") || newUser.getPassword().equals("") || passwordCheck.equals("")) {
                model.clear();
                model.put("alert", "일부 항목이 공백입니다");
                return "/auth/JoinForm.jsp";
            }

            // checking id is duplicate
            if (!userService.isValidateId(newUser.getId())) {
                model.clear();
                model.put("alert", "이미 존재하는 아이디입니다");
                return "/auth/JoinForm.jsp";
            }

            // checking id is valid
            if (newUser.getId().length() < 6) {
                model.clear();
                model.put("alert", "아이디는 6자 이상이어야 합니다");
                return "/auth/JoinForm.jsp";
            }

            // checking pwd/pwd check are inscription
            if (!newUser.getPassword().equals(passwordCheck)) {
                model.clear();
                model.put("alert", "비밀번호와 비밀번호 확인일 일치하지 않습니다");
                return "/auth/JoinForm.jsp";
            }

            // checking password is valid
            if (newUser.getPassword().length() < 9) {
                model.clear();
                model.put("alert", "비밀번호는 9자 이상이어야 합니다.");
                return "/auth/JoinForm.jsp";
            }

            // all form is valid
            model.put("id", newUser.getId());
            model.put("password", newUser.getPassword());
            return "/auth/JoinForm2.jsp";

        }

        // second form (input name)
        else {
            if (!userService.isValidateName(newUser.getName())) {

                model.put("id", newUser.getId());
                model.put("password", newUser.getPassword());
                model.put("alert", "이미 존재하는 이름입니다");
                return "/auth/JoinForm2.jsp";
            } else {
                userService.joinUser(newUser);
                return "redirect:login.do";
            }

        }
    }
}
