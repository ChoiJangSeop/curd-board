package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlCommentDao;

import java.util.Map;

public class CommentDeleteController implements Controller, DataBinding {

    MySqlCommentDao commentDao;

    public CommentDeleteController setCommentDao(MySqlCommentDao commentDao) {
        this.commentDao = commentDao;
        return this;
    }

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
                "fno", Integer.class,
                "cno", Integer.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        int fno = (Integer) model.get("fno");
        int cno = (Integer) model.get("cno");

        commentDao.delete(cno);

        return "redirect:content.do?no="+fno;
    }


}
