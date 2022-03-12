package crud_board.listener;

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

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            ServletContext sc = event.getServletContext();

            InitialContext initialContext = new InitialContext();

            DataSource ds = (DataSource) initialContext.lookup(
                    "java:comp/env/jdbc/crudboard_db"
            );

            MySqlFeedDao feedDao = new MySqlFeedDao();
            MySqlUserDao userDao = new MySqlUserDao();

            sc.setAttribute("/auth/login.do", new LogInController().setUserDao(userDao));
            sc.setAttribute("/auth/logout.do", new LogOutController());
            sc.setAttribute("/auth/join.do", new JoinController().setUserDao(userDao));
            sc.setAttribute("/feed/main.do", new FeedListController().setFeedDao(feedDao));
            sc.setAttribute("/feed/content.do", new FeedContentController().setFeedDao(feedDao));
            sc.setAttribute("/feed/add.do", new FeedAddController().setFeedDao(feedDao));
            sc.setAttribute("/feed/edit.do", new FeedEditController().setFeedDao(feedDao));
            sc.setAttribute("/feed/delete.do", new FeedDeleteController().setFeedDao(feedDao));

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {}
}
