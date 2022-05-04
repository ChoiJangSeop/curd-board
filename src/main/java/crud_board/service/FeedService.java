package crud_board.service;

import crud_board.dao.FeedDao;
import crud_board.dao.MySqlFeedDao;
import crud_board.vo.Feed;

import java.util.ArrayList;
import java.util.List;

public class FeedService {

    private FeedDao feedDao;

    public FeedService setFeedDao(FeedDao feedDao) {
        this.feedDao = feedDao;
        return this;
    }

    public List<Feed> selectList() throws Exception {
        return feedDao.selectList();
    }

    public Feed selectById(int id) throws Exception {
        return feedDao.selectOne(id);
    }

    public int insertFeed(Feed feed) throws Exception {
        return feedDao.insert(feed);
    }

    public int deleteFeedById(int id) throws Exception {
        return feedDao.delete(id);
    }

    public int editFeed(int no, String title, String content) throws Exception {
        Feed feed = selectById(no);
        feed.setTitle(title);
        feed.setContent(content);

        return feedDao.update(feed);
    }

    public int updateViews(int id) throws Exception {
        Feed feed = feedDao.selectOne(id);
        int views = feed.getViews();
        feed.setViews(views + 1);

        return feedDao.update(feed);
    }

    public int updateLikes(int id) throws Exception {
        Feed feed = feedDao.selectOne(id);
        int likes = feed.getLikes();
        feed.setLikes(likes + 1);

        return feedDao.update(feed);
    }

    public List<Feed> selectMostViewList() throws Exception {
        final int MOST_VIEWS = 10;

        List<Feed> feeds = feedDao.selectList();
        List<Feed> result = new ArrayList<>();

        int cnt = 0;

        for (Feed feed : feeds) {
            if (feed.getViews() >= MOST_VIEWS) {
                result.add(feed);
                cnt++;
            }

            if (cnt == 10) break;
        }

        return result;
    }

    public List<Feed> selectMostLikeList() throws Exception {
        final int MOST_LIKES = 1;

        List<Feed> feeds = feedDao.selectList();
        List<Feed> result = new ArrayList<>();

        int cnt = 0;

        for (Feed feed : feeds) {
            if (feed.getLikes() >= MOST_LIKES) {
                result.add(feed);
                cnt++;
            }

            if (cnt == 10) break;
        }

        return result;
    }

}
