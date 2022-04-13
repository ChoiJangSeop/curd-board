package crud_board.service;

import crud_board.dao.UserDao;
import crud_board.vo.User;

import java.util.List;

public class UserService {

    private UserDao userDao;

    public UserService setUserDao(UserDao userDao) {
        this.userDao = userDao;
        return this;
    }

    public User joinUser(User user) throws Exception {
        userDao.insert(user);
        return user;
    }

    // TODO rename
    public int isExist(String id, String password) throws Exception {
        User user = userDao.selectOneById(id);

        if (user != null && user.getPassword().equals(password)) {
            return user.getNo();
        }
        return -1;
    }

    public boolean isValidateId(String newId) throws Exception {
        User user = userDao.selectOneById(newId);

        if (user != null) {
             return false;
        }
        return true;
    }


    public boolean isValidateName(String newName) throws Exception {
        User user = userDao.selectOneByName(newName);

        if (user != null) {
            return false;
        }
        return true;
    }


}
