package crud_board.controllers;

import crud_board.dao.MySqlPeedDao;

import java.util.Map;

public class PeedDeleteController implements Controller {

    MySqlPeedDao peedDao;

    public PeedDeleteController setPeedDao(MySqlPeedDao peedDao) {
        this.peedDao = peedDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        int no = (Integer) model.get("no");
        peedDao.delete(no);
        return "redirect:main.do";
    }
}
