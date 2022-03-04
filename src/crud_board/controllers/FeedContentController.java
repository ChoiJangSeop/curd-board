package crud_board.controllers;

import crud_board.dao.MySqlFeedDao;

import java.util.Map;

public class FeedContentController implements Controller {

    MySqlFeedDao feedDao;

    public FeedContentController setFeedDao(MySqlFeedDao feedDao) {
        this.feedDao = feedDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        if (model.get("no") != null) {
            Integer no = (Integer) model.get("no");
            model.put("feed", feedDao.selectOne(no));
            return "/feed/FeedContent.jsp";
        } else {
            return "error.jsp";
        }
    }
}
