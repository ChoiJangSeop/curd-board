package crud_board.controllers;

import crud_board.dao.MySqlFeedDao;

import java.util.Map;

public class FeedDeleteController implements Controller {

    MySqlFeedDao feedDao;

    public FeedDeleteController setFeedDao(MySqlFeedDao feedDao) {
        this.feedDao = feedDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        int no = (Integer) model.get("no");
        feedDao.delete(no);
        return "redirect:main.do";
    }
}
