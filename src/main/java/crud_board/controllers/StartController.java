package crud_board.controllers;

import crud_board.bind.DataBinding;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

public class StartController implements Controller, DataBinding {

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
            "start", String.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        String start = (String) model.get("start");


        if (start != null && start.equals("anonymous")) {
            HttpSession session = (HttpSession) model.get("session");

            session.setAttribute("loginUser", "익명");
            session.setAttribute("searchLog", new ArrayList<String>());
            session.setAttribute("likeLog", new ArrayList<Integer>());

            return "redirect:../feed/main.do";
        } else {
            return "/auth/StartForm.jsp";
        }


    }


}
