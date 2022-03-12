package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlFeedDao;
import crud_board.vo.Feed;

import java.util.Map;

public class FeedEditController implements Controller, DataBinding {

    MySqlFeedDao peedDao;

    public FeedEditController setFeedDao(MySqlFeedDao peedDao) {
        this.peedDao = peedDao;
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

        Feed editFeed = (Feed) model.get("editFeed");
        int no = (Integer) model.get("no");

        if (editFeed.getTitle() == null) {
            model.put("editFeed", peedDao.selectOne(no));
            return "/feed/FeedEditForm.jsp";
        } else {
            peedDao.update(editFeed);
            return "redirect:content.do?no="+ editFeed.getNo();
        }
    }
}
