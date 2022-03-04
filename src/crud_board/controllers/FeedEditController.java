package crud_board.controllers;

import crud_board.dao.MySqlFeedDao;
import crud_board.vo.Feed;

import java.util.Map;

public class FeedEditController implements Controller {

    MySqlFeedDao peedDao;

    public FeedEditController setFeedDao(MySqlFeedDao peedDao) {
        this.peedDao = peedDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        if (model.get("editFeed") == null) {
            int no = (Integer) model.get("no");
            model.put("editFeed", peedDao.selectOne(no));
            return "/feed/FeedEditForm.jsp";
        } else {
            Feed editFeed = (Feed) model.get("editFeed");
            peedDao.update(editFeed);
            return "redirect:content.do?no="+ editFeed.getNo();
        }
    }
}
