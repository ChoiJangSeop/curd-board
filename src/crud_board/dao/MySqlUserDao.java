package crud_board.dao;

import crud_board.vo.Feed;
import crud_board.vo.User;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao {

    DataSource ds;

    public void setDataSource(DataSource ds) {
        this.ds = ds;
    }

    public List<User> selectList() throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT UNO, NAME, ID, PWD FROM users ORDER BY ASC");

            ArrayList<User> users = new ArrayList<>();

            while (rs.next()) {
                users.add(new User()
                        .setNo(rs.getInt("UNO"))
                        .setName(rs.getString("NAME"))
                        .setId(rs.getString("ID"))
                        .setPassword(rs.getString("PWD")));
            }

            return users;
        } catch (Exception e) { throw e; }
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public User selectOne(int no) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT UNO, NAME, ID, PWD FROM users WHERE UNO=" + no);

            User user = null;

            if (rs.next()) {
                user = new User()
                        .setNo(rs.getInt("UNO"))
                        .setName(rs.getString("NAME"))
                        .setId(rs.getString("ID"))
                        .setPassword(rs.getString("PWD"));
            }

            return user;

        } catch (Exception e) { throw e; }
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public int insert(User user) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("INSERT INTO users (NAME, ID, PWD) VALUES (?, ?, ?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getId());
            stmt.setString(3, user.getPassword());

            return stmt.executeUpdate();

        } catch (Exception e) { throw e; }
        finally {
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public int delete(int no) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("DELETE FROM users WHERE UNO=?");
            stmt.setInt(1, no);

            return stmt.executeUpdate();

        } catch (Exception e) { throw e; }
        finally {
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public int update(User user) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("UPDATE peeds SET NAME=?, ID=? PWD=? WHERE PNO=?");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getId());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getNo());

            return stmt.executeUpdate();

        } catch (Exception e) { throw e; }
        finally {
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public boolean exist(String id, String password) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement("SELECT UNO FROM users WHERE ID=? AND PWD=?");
            stmt.setString(1, id);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) { throw e; }
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}
