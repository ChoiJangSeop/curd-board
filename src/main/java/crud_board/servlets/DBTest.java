package crud_board.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/dbtest")
public class DBTest extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            ServletContext sc = this.getServletContext();

            Class.forName(sc.getInitParameter("driver"));
            conn = DriverManager.getConnection(
                    sc.getInitParameter("url"),
                    sc.getInitParameter("username"),
                    sc.getInitParameter("password")
            );
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT TITLE FROM peeds");

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<html><head><title>테스트</title></head>");
            out.println("<body>");

            while (rs.next()) {
                out.println(rs.getString("title"));
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}
