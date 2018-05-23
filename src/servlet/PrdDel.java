package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

public class PrdDel extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String pid = request.getParameter("pid");
		System.out.println("del:" + pid);
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = conn
					.prepareStatement("delete from t_prd where pid=?");
			prep.setString(1, pid);
			prep.executeUpdate();
			response.sendRedirect("mainPrd.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		} finally {
			try {
				DBUtil.close(conn);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}
}
