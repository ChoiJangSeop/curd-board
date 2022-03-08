package crud_board.controllers;

import crud_board.dao.MySqlFeedDao;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class FeedListController implements Controller {

    MySqlFeedDao feedDao;

    public FeedListController setFeedDao(MySqlFeedDao feedDao) {
        this.feedDao = feedDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        HttpSession session = (HttpSession) model.get("session");

        if (session.getAttribute("loginUser") == null) {
            return "redirect:../auth/login.do";
        }

        model.put("loginUser", session.getAttribute("loginUser"));
        model.put("feeds", feedDao.selectList());
        return "/feed/FeedList.jsp";
    }
}
