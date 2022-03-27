package crud_board.dao;

import crud_board.vo.Comment;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlCommentDao {

    public DataSource ds;

    public void setDataSource(DataSource ds) { this.ds = ds; }

    public List<Comment> selectList(int fno) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT CNO, CONTENT, WRITER, CRE_DATE FROM COMMENTS WHERE PNO="+fno);

            List<Comment> comments = new ArrayList<>();

            while (rs.next()) {
                comments.add(new Comment()
                        .setNo(rs.getInt("CNO"))
                        .setContent(rs.getString("CONTENT"))
                        .setWriter(rs.getString("WRITER"))
                        .setCreatedDate(rs.getDate("CRE_DATE"))
                );
            }

            return comments;
        } catch (Exception e) { throw e; }
        finally {
            closeAll(conn, stmt, null, rs);
        }
    }

    public int insert(Comment comment, int no) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
             conn = ds.getConnection();
             stmt = conn.prepareStatement("INSERT INTO COMMENTS (PNO, CONTENT, WRITER, CRE_DATE) VALUES (?, ?, ?, NOW())");
             stmt.setInt(1, no);
             stmt.setString(2, comment.getContent());
             stmt.setString(3, comment.getWriter());

             return stmt.executeUpdate();

        } catch (Exception e) { throw e; }
        finally {
            closeAll(conn, null, stmt, null);
        }
    }

    public int delete(int cno) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("DELETE FROM COMMENTS WHERE CNO=?");
            stmt.setInt(1, cno);

            return stmt.executeUpdate();
        } catch (Exception e) { throw e; }
        finally {
            closeAll(conn, null, stmt, null);
        }
    }

    public int countComments(int fno) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) FROM COMMENTS WHERE PNO="+fno);

            if (rs.next()) {
                return rs.getInt("COUNT(*)");
            } else {
                return -1;
            }


        } catch (Exception e) { throw e; }
        finally {
            closeAll(conn, stmt, null, rs);
        }
    }

    private void closeAll(Connection conn, Statement stmt, PreparedStatement pre_stmt, ResultSet rs) {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (pre_stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
}
