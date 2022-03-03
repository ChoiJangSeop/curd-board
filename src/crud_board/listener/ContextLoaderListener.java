package crud_board.listener;

import crud_board.dao.MySqlPeedDao;
import crud_board.dao.MySqlUserDao;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.util.logging.Logger;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    private static final Logger LOG = Logger.getGlobal();

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            ServletContext sc = event.getServletContext();

            InitialContext initialContext = new InitialContext();

            DataSource ds = (DataSource) initialContext.lookup(
                    "java:comp/env/jdbc/crudboard_db"
            );

            MySqlPeedDao peedDao = new MySqlPeedDao();
            MySqlUserDao userDao = new MySqlUserDao();

            peedDao.setDataSource(ds);
            userDao.setDataSource(ds);

            sc.setAttribute("peedDao", peedDao);
            sc.setAttribute("userDao", userDao);

            LOG.info("[ContextLoaderListener.contextInitialized() success]");
        } catch (Throwable e) {
            LOG.severe("[ContextLoaderListener.contextInitialized() failed] " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {}
}
