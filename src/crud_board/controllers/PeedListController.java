package crud_board.controllers;

import crud_board.dao.MySqlPeedDao;

import java.util.Map;

public class PeedListController implements Controller {

    MySqlPeedDao peedDao;

    public PeedListController setPeedDao(MySqlPeedDao peedDao) {
        this.peedDao = peedDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        model.put("peeds", peedDao.selectList());
        return "/peed/PeedList.jsp";
    }
}
