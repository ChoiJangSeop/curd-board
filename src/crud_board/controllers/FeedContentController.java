package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlFeedDao;
import crud_board.vo.Feed;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class FeedContentController implements Controller, DataBinding {

    MySqlFeedDao feedDao;

    public FeedContentController setFeedDao(MySqlFeedDao feedDao) {
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

        Integer no = (Integer) model.get("no");
        HttpSession session = (HttpSession) model.get("session");

        Feed feed = feedDao.selectOne(no);
        String loginUser = (String) session.getAttribute("loginUser");

        // check authority to edit
        if (!loginUser.equals("익명") && loginUser.equals(feed.getWriter())) {
            model.put("authority", "");
        } else {
            model.put("authority", "disabled");
        }

        // feed content
        model.put("feed", feedDao.selectOne(no));
        return "/feed/FeedContent.jsp";
    }
}
