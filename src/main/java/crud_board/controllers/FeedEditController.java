package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlFeedDao;
import crud_board.service.FeedService;
import crud_board.vo.Feed;

import java.util.Map;

public class FeedEditController implements Controller, DataBinding {

    FeedService feedService;

    public FeedEditController setFeedService(FeedService feedService) {
        this.feedService = feedService;
        return this;
    }

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
                "no", Integer.class,
                "title", String.class,
                "content", String.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        int no = (Integer) model.get("no");
        String title = (String) model.get("title");
        String content = (String) model.get("content");

        if (title == null) {
            Feed feed = feedService.selectById(no);
            content = feed.getContent();

            feed.setContent(content.replace("<br>", "\r\n"));

            model.put("editFeed", feed);
            return "/feed/FeedEditForm.jsp";
        } else {
            content = content.replace("\r\n", "<br>");

            feedService.editFeed(no, title, content);
            return "redirect:content.do?no="+ no;
        }
    }
}
