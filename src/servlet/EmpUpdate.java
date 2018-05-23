package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

public class EmpUpdate extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String eid= request.getParameter("eid");
		String password = request.getParameter("password");
		String ename = request.getParameter("ename");
		String sex = request.getParameter("sex");
		int eage = Integer.parseInt(request.getParameter("eage"));
		int salary =Integer.parseInt(request.getParameter("salary"));
		String ismanager = request.getParameter("ismanager");
		String tel = request.getParameter("tel");
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();

			PreparedStatement prep = conn.prepareStatement(
					"update t_emp set password=?,ename=?,sex=?,eage=?,salary=?,ismanager=?,tel=?" +
					"where eid=?");
			// System.out.println(bookno+"~");
			prep.setString(1, password);
			prep.setString(2, ename);
			prep.setString(3, sex);
			prep.setInt(4, eage);
			prep.setInt(5, salary);
			prep.setString(6, ismanager);
			prep.setString(7, tel);
			prep.setString(8, eid);
			prep.executeUpdate();
//			System.out.println("update:"+eid+" "+ename);
			response.sendRedirect("manage_emp.jsp");
//			request.getRequestDispatcher("manage_emp.jsp").forward(request, response);
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
