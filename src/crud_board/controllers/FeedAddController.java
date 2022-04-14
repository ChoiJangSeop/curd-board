package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlFeedDao;
import crud_board.service.FeedService;
import crud_board.vo.Feed;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class FeedAddController implements Controller, DataBinding {

    private FeedService feedService;

    public FeedAddController setFeedService(FeedService feedService) {
        this.feedService = feedService;
        return this;
    }

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
                "feed", crud_board.vo.Feed.class,
                "password", String.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        Feed feed = (Feed) model.get("feed");
        String password = (String) model.get("password");
        HttpSession session = (HttpSession) model.get("session");

        if (feed.getTitle() == null) {
            if (session.getAttribute("loginUser").equals("익명")) {
                model.put("authority", "");
            } else {
                model.put("authority", "disabled");
            }

            return "/feed/FeedAddForm.jsp";
        } else {
            if (session.getAttribute("loginUser").equals("익명")) {
                feed.setWriter("익명" + password);
            } else {
                feed.setWriter((String) session.getAttribute("loginUser"));
            }

            //feedDao.insert(feed, session);
            feedService.insertFeed(feed);
            return "redirect:main.do";
        }
    }
}
