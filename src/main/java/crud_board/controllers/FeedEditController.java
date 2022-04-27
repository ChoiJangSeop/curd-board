package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlFeedDao;
import crud_board.service.FeedService;
import crud_board.vo.Feed;

import java.util.Map;

public class FeedEditController implements Controller, DataBinding {

    //MySqlFeedDao feedService;
    FeedService feedService;
/*
    public FeedEditController setFeedDao(MySqlFeedDao peedDao) {
        this.feedService = peedDao;
        return this;
    }
*/
    public FeedEditController setFeedService(FeedService feedService) {
        this.feedService = feedService;
        return this;
    }

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
          "editFeed", crud_board.vo.Feed.class,
                "no", Integer.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        Feed editedFeed = (Feed) model.get("editFeed");
        int no = (Integer) model.get("no");

        if (editedFeed.getTitle() == null) {
            Feed feed = feedService.selectById(no);
            String content = feed.getContent();

            feed.setContent(content.replace("<br>", "\r\n"));

            model.put("editFeed", feed);
            return "/feed/FeedEditForm.jsp";
        } else {
            String content = editedFeed.getContent();
            editedFeed.setContent(content.replace("\r\n", "<br>"));

            feedService.editFeed(editedFeed);
            return "redirect:content.do?no="+ editedFeed.getNo();
        }
    }
}
