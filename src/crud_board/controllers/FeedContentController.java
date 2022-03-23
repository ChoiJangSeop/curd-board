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
                "no", Integer.class,
                "password", String.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        Integer no = (Integer) model.get("no");
        HttpSession session = (HttpSession) model.get("session");
        Feed feed = feedDao.selectOne(no);

        // check authority to modify
        if (model.get("password") != null) {
            String password = (String) model.get("password");

            if (feed.getWriter().startsWith("익명")) {
                if (!password.equals(feed.getWriter().substring(2))) {
                    model.put("feed", feedDao.selectOne(no));
                    model.put("alert", "수정 권한 비밀번호가 틀렸습니다");
                    return "/feed/FeedContent.jsp";
                }
            } else {
                if (!feed.getWriter().equals(session.getAttribute("loginUser"))) {
                    model.put("feed", feedDao.selectOne(no));
                    model.put("alert", "수정 권한 비밀번호가 틀렸습니다");
                    return "/feed/FeedContent.jsp";
                }
            }

            return "redirect:edit.do?no="+no;
        }

        String loginUser = (String) session.getAttribute("loginUser");

        // check authority to edit
        if (!feed.getWriter().startsWith("익명")) {
            model.put("authority", "readonly");
        } else {
            model.put("authority", "");
        }

        // update views
        feedDao.updateViews(no);

        // feed content
        model.put("feed", feedDao.selectOne(no));
        return "/feed/FeedContent.jsp";
    }
}
