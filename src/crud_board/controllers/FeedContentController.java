package crud_board.controllers;

import crud_board.bind.DataBinding;
import crud_board.dao.MySqlCommentDao;
import crud_board.dao.MySqlFeedDao;
import crud_board.service.CommentService;
import crud_board.service.FeedService;
import crud_board.vo.Comment;
import crud_board.vo.Feed;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class FeedContentController implements Controller, DataBinding {

    private FeedService feedService;
    private CommentService commentService;

    public FeedContentController setCommentService(CommentService commentService) {
        this.commentService = commentService;
        return this;
    }

    public FeedContentController setFeedService(FeedService feedService) {
        this.feedService = feedService;
        return this;
    }

    @Override
    public Object[] getDataBinders() {
        return new Object[] {
                "no", Integer.class,
                "password", String.class,
                "comment", String.class
        };
    }

    @Override
    public String execute(Map<String, Object> model) throws Exception {

        Integer no = (Integer) model.get("no");
        HttpSession session = (HttpSession) model.get("session");
        Feed feed = feedService.selectById(no);
        //Feed feed = feedDao.selectOne(no);

        String loginUser = (String) session.getAttribute("loginUser");

        // 1. check authority to modify when click modify button
        if (model.get("password") != null) {
            String password = (String) model.get("password");

            if (feed.getWriter().startsWith("익명")) {
                if (password.equals(feed.getWriter().substring(2))) {
                    return "redirect:edit.do?no="+no;
                }
            } else {
                if (feed.getWriter().equals(session.getAttribute("loginUser"))) {
                    return "redirect:edit.do?no="+no;
                }
            }

            model.put("alert", "수정 권한이 없습니다");
        }

        // 2. create comments
        if (model.get("comment") != null) {
            String content = (String) model.get("comment");

            Comment comment = new Comment()
                    .setContent(content)
                    .setWriter(loginUser);

            commentService.insertComment(comment, no);
        }

        // 3. enter content page

        // check authority to edit
        if (!feed.getWriter().startsWith("익명")) {
            model.put("authority", "readonly");
        } else {
            model.put("authority", "");
        }

        // update views
        //feedDao.updateViews(no);
        feedService.updateViews(no);
        Integer counts = Integer.valueOf(commentService.countCommentsByFeed(no));

        // parse feed writer name
        if (feed.getWriter().startsWith("익명")) {
            feed.setWriter("익명");
        }

        // feed content
        model.put("comments", commentService.selectListByFeed(no));
        model.put("counts", counts.toString());
        model.put("feed", feed);
        model.put("mostViewFeeds", feedService.selectMostViewList());
        return "/feed/FeedContent.jsp";
    }
}
