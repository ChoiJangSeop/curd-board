package crud_board.service;
/*
import crud_board.dao.MySqlFeedTestDao;
import crud_board.vo.Feed;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.List;
*/

public class FeedServiceTest {
/*
    public MySqlFeedTestDao feedDao = new MySqlFeedTestDao();
    public FeedService feedService = new FeedService().setFeedDao(feedDao);


    @Before
    public void initTable() throws Exception {
        feedDao.deleteAll();
        System.out.println("feedDao.deleteAll()");
    }

    @Test
    public void testSelectList() throws Exception {
        // given
        feedDao.deleteAll();
        Feed feed1 = new Feed()
                .setTitle("test1")
                .setContent("test1")
                .setWriter("test1");
        Feed feed2 = new Feed()
                .setTitle("test2")
                .setContent("test2")
                .setWriter("test2");

        feedService.insertFeed(feed1);
        feedService.insertFeed(feed2);

        // when
        List<Feed> feeds = feedService.selectList();

        // then
        assertEquals(feeds.size(), 2);
    }

    @Test
    public void testSelectById() throws Exception {
        // given
        feedDao.deleteAll();
        Feed feed1 = new Feed()
                .setTitle("testSelectById")
                .setContent("testSelectById")
                .setWriter("testSelectById");
        feedService.insertFeed(feed1);

        // when
        Feed selectFeed = feedService.selectById(1);

        // then
        assertEquals(selectFeed.getTitle(), "testSelectById");
    }

    public void testEditFeed() throws Exception {
        feedDao.deleteAll();

        // given
        Feed feed = new Feed()
                .setTitle("testEditFeed")
                .setContent("testEditFeed")
                .setWriter("testEditFeed");
        feedService.insertFeed(feed);


        // when
        feed.setTitle("testEditFeedEdited");
        feed.setNo(1);
        feedService.editFeed(feed);

        // then
        Feed selectedFeed = feedService.selectById(1);
        assertEquals(selectedFeed.getTitle(), "testEditFeedEdited");
    }

    public void testUpdateViews() throws Exception {
        feedDao.deleteAll();

        // given
        Feed feed = new Feed()
                .setTitle("testUpdateViews")
                .setContent("testUpdateViews")
                .setWriter("testUpdateViews");
        feedService.insertFeed(feed);
        int originView = feedService.selectById(1).getViews();

        // when
        feedService.updateViews(1);

        // then
        assertEquals(originView+1, feedService.selectById(1).getViews());
    }

    public void testUpdateLikes() throws Exception {
        feedDao.deleteAll();

        // given
        Feed feed = new Feed()
                .setTitle("testUpdateLikes")
                .setContent("testUpdateLikes")
                .setWriter("testUpdateLikes");
        feedService.insertFeed(feed);
        int originLike = feedService.selectById(1).getLikes();

        // when
        feedService.updateLikes(1);

        // then
        assertEquals(originLike+1, feedService.selectById(1).getLikes());
    }

    public void testSelectMostViewList() throws Exception {
        feedDao.deleteAll();

        // given
        Feed feed1 = new Feed()
                .setTitle("feed1")
                .setContent("feed1")
                .setWriter("feed1")
                .setViews(3);

        Feed feed2 = new Feed()
                .setTitle("feed2")
                .setContent("feed2")
                .setWriter("feed2")
                .setViews(15);

        Feed feed3 = new Feed()
                .setTitle("feed3")
                .setContent("feed3")
                .setWriter("feed3")
                .setViews(7);

        Feed feed4 = new Feed()
                .setTitle("feed4")
                .setContent("feed4")
                .setWriter("feed4")
                .setViews(100);

        feedService.insertFeed(feed1);
        feed1.setNo(1); feedService.editFeed(feed1);
        feedService.insertFeed(feed2);
        feed2.setNo(2); feedService.editFeed(feed2);
        feedService.insertFeed(feed3);
        feed3.setNo(3); feedService.editFeed(feed3);
        feedService.insertFeed(feed4);
        feed4.setNo(4); feedService.editFeed(feed4);

        // when
        List<Feed> feeds = feedService.selectMostViewList();

        // then
        assertEquals(2, feeds.size());


    }
    */

}