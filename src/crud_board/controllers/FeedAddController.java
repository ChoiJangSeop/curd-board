package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlFeedDao;
import crud_board.vo.Feed;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class FeedAddController implements Controller, DataBinding {

    MySqlFeedDao feedDao;

    public FeedAddController setFeedDao(MySqlFeedDao feedDao) {
        this.feedDao = feedDao; return this;
    }

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
          "feed", crud_board.vo.Feed.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        Feed feed = (Feed) model.get("feed");
        HttpSession session = (HttpSession) model.get("session");

        if (feed.getTitle() == null) {
            return "/feed/FeedAddForm.jsp";
        } else {
            feedDao.insert(feed, session);
            return "redirect:main.do";
        }
    }
}
