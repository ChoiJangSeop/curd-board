package crud_board.controllers;

import crud_board.dao.MySqlFeedDao;
import crud_board.vo.Feed;

import java.util.Map;

public class FeedAddController implements Controller {

    MySqlFeedDao feedDao;

    public FeedAddController setFeedDao(MySqlFeedDao feedDao) {
        this.feedDao = feedDao; return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        if (model.get("feed") == null) {
            return "/feed/FeedAddForm.jsp";
        } else {
            Feed feed = (Feed) model.get("feed");
            feedDao.insert(feed);
            return "redirect:main.do";
        }
    }
}
