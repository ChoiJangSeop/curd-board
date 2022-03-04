package crud_board.controllers;

import crud_board.dao.MySqlPeedDao;
import crud_board.vo.Peed;

import java.util.Map;

public class PeedEditController implements Controller {

    MySqlPeedDao peedDao;

    public PeedEditController setPeedDao(MySqlPeedDao peedDao) {
        this.peedDao = peedDao;
        return this;
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {
        if (model.get("editPeed") == null) {
            int no = (Integer) model.get("no");
            model.put("editPeed", peedDao.selectOne(no));
            return "/peed/PeedEditForm.jsp";
        } else {
            Peed editPeed = (Peed) model.get("editPeed");
            peedDao.update(editPeed);
            return "redirect:content.do?no="+ editPeed.getNo();
        }
    }
}
