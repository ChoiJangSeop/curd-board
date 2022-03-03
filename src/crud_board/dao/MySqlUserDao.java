package crud_board.dao;

import javax.sql.DataSource;

public class MySqlUserDao {

    DataSource ds;

    public void setDataSource(DataSource ds) {
        this.ds = ds;
    }
}
