package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

public class EmpDel extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String eid = request.getParameter("eid");
//		System.out.println("del:" + eid);
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement("delete from t_emp where eid=?");
			prep.setString(1, eid);
			prep.executeUpdate();
//			System.out.println("~~~!!!");
//			request.getRequestDispatcher("manage_emp.jsp").forward(request, response);
			response.sendRedirect("manage_emp.jsp");
//			response.sendRedirect("index.jsp");
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
