package crud_board.dao;

import crud_board.vo.User;

import java.util.List;

public interface UserDao {

    public List<User> selectList() throws Exception;
    public User selectOne(int no) throws Exception;
    public User selectOneById(String id) throws Exception;
    public User selectOneByName(String name) throws Exception;
    public int insert(User user) throws Exception;
    public int delete(int no) throws Exception;
    public int update(User user) throws Exception;
}
