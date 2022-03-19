package crud_board.dao;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import crud_board.vo.Feed;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MySqlFeedDao {

    private static final Logger LOG = Logger.getGlobal();

    public DataSource ds;

    public void setDataSource(DataSource ds) {
        this.ds = ds;
    }

    public List<Feed> selectList() throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT PNO, TITLE, WRITER, CRE_DATE, LIKES, VIEWS FROM peeds ORDER BY PNO DESC");

            ArrayList<Feed> feeds = new ArrayList<>();

            while(rs.next()) {
                feeds.add(new Feed()
                        .setNo(rs.getInt("PNO"))
                        .setTitle(rs.getString("TITLE"))
                        .setWriter(rs.getString("WRITER"))
                        .setCreatedDate(rs.getDate("CRE_DATE"))
                        .setLikes(rs.getInt("LIKES"))
                        .setViews(rs.getInt("VIEWS"))
                );
            }

            LOG.info("[feedDAO.selectList() success]");
            return feeds;
        } catch (Exception e) {
            LOG.severe("[feedDAO.selectList failed] " + e.getMessage());
            throw e;
        }
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public Feed selectOne(int no) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Feed feed = null;

        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT PNO, TITLE, CONTENT, WRITER, CRE_DATE, LIKES, VIEWS FROM peeds WHERE PNO=" + no);

            if (rs.next()) {
                feed = new Feed()
                        .setNo(rs.getInt("PNO"))
                        .setTitle(rs.getString("TITLE"))
                        .setWriter(rs.getString("WRITER"))
                        .setCreatedDate(rs.getDate("CRE_DATE"))
                        .setContent(rs.getString("CONTENT"))
                        .setLikes(rs.getInt("LIKES"))
                        .setViews(rs.getInt("VIEWS"));
            }

            return feed;
        } catch (Exception e) { throw e; }
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public int insert(Feed feed, HttpSession session) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("INSERT INTO peeds (TITLE, CONTENT, WRITER, CRE_DATE) " +
                    "VALUES (?, ?, ?, NOW())");
            stmt.setString(1, feed.getTitle());
            stmt.setString(2, feed.getContent());
            stmt.setString(3, (String) session.getAttribute("loginUser"));
            stmt.executeUpdate();

        } catch (Exception e) {}
        finally {
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
            return 0;
        }
    }

    public int delete(int no) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("DELETE FROM peeds WHERE PNO=?");
            stmt.setInt(1, no);
            stmt.executeUpdate();
        } catch (Exception e) { throw e; }
        finally {
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
            return 0;
        }
    }

    public int update(Feed feed) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("UPDATE peeds SET TITLE=?, CONTENT=? WHERE PNO=?");
            stmt.setString(1, feed.getTitle());
            stmt.setString(2, feed.getContent());
            stmt.setInt(3, feed.getNo());
            stmt.executeUpdate();

        } catch (Exception e) { throw e; }
        finally {
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
            return 0;
        }
    }

    public int updateViews(int no) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("UPDATE peeds SET VIEWS = VIEWS + 1 WHERE PNO=?");
            stmt.setInt(1, no);

            return stmt.executeUpdate();
        } catch (Exception e) { throw e; }
        finally {
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}
