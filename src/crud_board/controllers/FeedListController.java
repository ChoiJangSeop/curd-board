package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlFeedDao;
import crud_board.vo.Feed;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeedListController implements Controller, DataBinding {

    MySqlFeedDao feedDao;

    public FeedListController setFeedDao(MySqlFeedDao feedDao) {
        this.feedDao = feedDao;
        return this;
    }

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
                "text", String.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        HttpSession session = (HttpSession) model.get("session");
        List<Feed> feeds = feedDao.selectList();
        String text = (String) model.get("text");

        if (session.getAttribute("loginUser") == null) {
            return "redirect:../auth/login.do";
        }

        if (text != null) {
            List<Feed> searchFeeds = new ArrayList<>();

            for (Feed feed : feeds) {
                if (text.trim().length() == 0) break;

                String title = feed.getTitle().trim();

                if (title.contains(text.trim())) {
                    searchFeeds.add(feed);
                }
            }
            model.put("feeds", searchFeeds);
        } else {
            model.put("feeds", feeds);
        }

        model.put("loginUser", session.getAttribute("loginUser"));
        return "/feed/FeedList.jsp";
    }
}
