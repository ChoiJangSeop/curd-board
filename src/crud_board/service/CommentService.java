package crud_board.service;

import crud_board.dao.CommentDao;
import crud_board.vo.Comment;

import java.util.List;

public class CommentService {

    CommentDao commentDao;

    public CommentService setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
        return this;
    }

    public List<Comment> selectListByFeed(int fno) throws Exception {
        return commentDao.selectListByFeedNo(fno);
    }

    public int insertComment(Comment comment, int fno) throws Exception {
        return commentDao.insert(comment, fno);
    }

    public int countCommentsByFeed(int fno) throws Exception {
        return commentDao.countCommentsByFeedNo(fno);
    }
}
