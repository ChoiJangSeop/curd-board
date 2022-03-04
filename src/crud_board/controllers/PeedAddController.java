package crud_board.controllers;

import crud_board.dao.MySqlPeedDao;
import crud_board.vo.Peed;

import java.util.Map;

public class PeedAddController implements Controller {

    MySqlPeedDao peedDao;

    public PeedAddController setPeedDao(MySqlPeedDao peedDao) {
        this.peedDao = peedDao; return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        if (model.get("peed") == null) {
            return "/peed/PeedAddForm.jsp";
        } else {
            Peed peed = (Peed) model.get("peed");
            peedDao.insert(peed);
            return "redirect:main.do";
        }
    }
}
