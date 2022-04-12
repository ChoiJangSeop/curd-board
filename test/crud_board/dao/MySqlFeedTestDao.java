package crud_board.dao;

import crud_board.vo.Feed;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlFeedTestDao implements FeedDao {

    public List<Feed> selectList() throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT PNO, TITLE, WRITER, CRE_DATE, LIKES, VIEWS FROM FEEDS ORDER BY PNO DESC");

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
            return feeds;
        } catch (Exception e) {
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
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT PNO, TITLE, CONTENT, WRITER, CRE_DATE, LIKES, VIEWS FROM FEEDS WHERE PNO=" + no);

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
            closeAll(conn, stmt, null, rs);
        }
    }

    // overloading
    public int insert(Feed feed) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO FEEDS (TITLE, CONTENT, WRITER, CRE_DATE) " +
                    "VALUES (?, ?, ?, NOW())");
            stmt.setString(1, feed.getTitle());
            stmt.setString(2, feed.getContent().replace("\r\n", "<br>"));
            stmt.setString(3, feed.getWriter());
            return stmt.executeUpdate();

        } catch (Exception e) {}
        finally {
            closeAll(conn, null, stmt, null);
            return -1;
        }
    }

    public int delete(int no) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("DELETE FROM FEEDS WHERE PNO=?");
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        } catch (Exception e) { throw e; }
        finally {
            closeAll(conn, null, stmt, null);
            return -1;
        }
    }

    public int deleteAll() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = getConnection();
            pstmt1 = conn.prepareStatement("DELETE FROM FEEDS WHERE PNO >=0");
            pstmt1.executeUpdate();

            pstmt2 = conn.prepareStatement("ALTER TABLE FEEDS AUTO_INCREMENT=0");
            return pstmt2.executeUpdate();
        } catch (Exception e) { throw e; }
        finally {
            closeAll(conn, null, pstmt1, null);
            return -1;
        }
    }

    public int update(Feed feed) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE FEEDS SET TITLE=?, CONTENT=?, VIEWS=?, LIKES=? WHERE PNO=?");
            stmt.setString(1, feed.getTitle());
            stmt.setString(2, feed.getContent());
            stmt.setInt(3, feed.getViews());
            stmt.setInt(4,feed.getLikes());
            stmt.setInt(5, feed.getNo());
            stmt.executeUpdate();

        } catch (Exception e) { throw e; }
        finally {
            closeAll(conn, null, stmt, null);
            return 0;
        }
    }


    private Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/crudboard_db_test?serverTimezone=UTC";
        String userName = "root";
        String password = "dkq041675!";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, userName, password);

        return conn;
    }

    private void closeAll(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }

}