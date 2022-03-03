package crud_board.controllers;

import crud_board.dao.MySqlPeedDao;

import java.util.Map;

public class PeedContentController implements Controller {

    MySqlPeedDao peedDao;

    public PeedContentController setPeedDao(MySqlPeedDao peedDao) {
        this.peedDao = peedDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        if (model.get("no") != null) {
            Integer no = (Integer) model.get("no");
            model.put("peed", peedDao.selectOne(no));
            return "/peed/PeedContent.jsp";
        } else {
            return "error.jsp";
        }
    }
}
