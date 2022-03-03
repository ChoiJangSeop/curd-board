package crud_board.dao;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import crud_board.vo.Peed;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MySqlPeedDao {

    private static final Logger LOG = Logger.getGlobal();

    public DataSource ds;

    public void setDataSource(DataSource ds) {
        this.ds = ds;
    }

    public List<Peed> selectList() throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT PNO, TITLE, WRITER, CRE_DATE, LIKES, VIEWS FROM peeds ORDER BY PNO ASC");

            ArrayList<Peed> peeds = new ArrayList<>();

            while(rs.next()) {
                peeds.add(new Peed()
                        .setNo(rs.getInt("PNO"))
                        .setTitle(rs.getString("TITLE"))
                        .setWriter(rs.getString("WRITER"))
                        .setCreatedDate(rs.getDate("CRE_DATE")));
            }

            LOG.info("[PeedDAO.selectList() success]");
            return peeds;
        } catch (Exception e) {
            LOG.severe("[peedDAO.selectList failed] " + e.getMessage());
            throw e;
        }
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public Peed selectOne(int no) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Peed peed = null;

        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT SELECT PNO, TITLE, CONTENT, WRITER, CRE_DATE, LIKES, VIEWS FROM peeds WHERE PNO=" + no);

            if (rs.next()) {
                peed = new Peed()
                        .setNo(rs.getInt("PNO"))
                        .setTitle(rs.getString("TITLE"))
                        .setWriter(rs.getString("WRITER"))
                        .setCreatedDate(rs.getDate("CRE_DATE"))
                        .setContent(rs.getString("CONTENT"));
            }

            return peed;
        } catch (Exception e) { throw e; }
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public int insert(Peed peed) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("INSERT INTO peeds (PNO, TITLE, CONTENT, WRITER, CRE_DATE) " +
                    "VALUES (?, ?, ?, ?, NOW())");
            stmt.setInt(1, peed.getNo());
            stmt.setString(2, peed.getTitle());
            stmt.setString(3, peed.getContent());
            stmt.setString(4, peed.getWriter());
            stmt.executeQuery();

        } catch (Exception e) {}
        finally {
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
            return 0;
        }
    }

    public int delete(int no) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            stmt.executeQuery("DELETE FROM peeds WHERE PNO=" + no);
        } catch (Exception e) { throw e; }
        finally {
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
            return 0;
        }
    }

    public int update(Peed peed) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("UPDATE peeds SET TITLE=?, CONTENT=? WHERE PNO=?");
            stmt.setString(1, peed.getTitle());
            stmt.setString(2, peed.getContent());
            stmt.setInt(3, peed.getNo());

        } catch (Exception e) { throw e; }
        finally {
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
            return 0;
        }
    }
}
