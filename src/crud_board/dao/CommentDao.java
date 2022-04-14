package crud_board.dao;

import crud_board.vo.Comment;

import java.util.List;

public interface CommentDao {

    public List<Comment> selectList() throws Exception;
    public List<Comment> selectListByFeedNo(int fno) throws Exception;
    public int insert(Comment comment, int no) throws Exception;
    public int delete(int cno) throws Exception;
    public int countCommentsByFeedNo(int fno) throws Exception;

}
