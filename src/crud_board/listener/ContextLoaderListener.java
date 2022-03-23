package crud_board.listener;

import crud_board.context.ApplicationContext;
import crud_board.controllers.*;
import crud_board.dao.MySqlFeedDao;
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
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            ServletContext sc = event.getServletContext();

            String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
            applicationContext = new ApplicationContext(propertiesPath);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {}
}
