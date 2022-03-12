package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlFeedDao;

import java.util.Map;

public class FeedDeleteController implements Controller, DataBinding {

    MySqlFeedDao feedDao;

    public FeedDeleteController setFeedDao(MySqlFeedDao feedDao) {
        this.feedDao = feedDao;
        return this;
    }

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
          "no", Integer.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        int no = (Integer) model.get("no");
        feedDao.delete(no);
        return "redirect:main.do";
    }
}
