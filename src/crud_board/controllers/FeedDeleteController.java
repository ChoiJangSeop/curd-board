package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlFeedDao;
import crud_board.service.FeedService;

import java.util.Map;

public class FeedDeleteController implements Controller, DataBinding {

    //MySqlFeedDao feedDao;
    FeedService feedService;
/*
    public FeedDeleteController setFeedDao(MySqlFeedDao feedDao) {
        this.feedDao = feedDao;
        return this;
    }
    */
    public FeedDeleteController setFeedService(FeedService feedService) {
        this.feedService = feedService;
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
        feedService.deleteFeedById(no);
        return "redirect:main.do";
    }
}
