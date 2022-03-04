package crud_board.controllers;

import crud_board.dao.MySqlFeedDao;

import java.util.Map;

public class FeedListController implements Controller {

    MySqlFeedDao feedDao;

    public FeedListController setFeedDao(MySqlFeedDao feedDao) {
        this.feedDao = feedDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        model.put("feeds", feedDao.selectList());
        return "/feed/FeedList.jsp";
    }
}
