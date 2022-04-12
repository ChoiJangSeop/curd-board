package crud_board.dao;

import crud_board.vo.Feed;

import java.util.List;

public interface FeedDao {
    public List<Feed> selectList() throws  Exception;
    public Feed selectOne(int no) throws  Exception;
    public int insert(Feed feed) throws  Exception;
    public int delete(int no) throws  Exception;
    public int update(Feed feed) throws  Exception;
    public int deleteAll() throws  Exception;

}
