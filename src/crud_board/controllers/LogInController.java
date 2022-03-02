package crud_board.controllers;

import java.util.Map;

public class LogInController implements Controller {
    @Override
    public String execute(Map<String, Object> model) throws Exception {
        return "/auth/LogIn.jsp";
    }
}
