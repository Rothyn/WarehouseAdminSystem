package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

public class PrdUpdate extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		int pnumber = Integer.parseInt(request.getParameter("pnumber"));
		String supplier = request.getParameter("supplier");
		String intime = request.getParameter("intime");
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = conn
					.prepareStatement("update t_prd set pname=?,price=?,pnumber=?,supplier=?,intime=? "
							+ "where pid=?");
			prep.setString(1, pname);
			prep.setString(2, price);
			prep.setInt(3, pnumber);
			prep.setString(4, supplier);
			prep.setString(5, intime);
			prep.setString(6, pid);
			prep.executeUpdate();
			System.out.println("!update:" + pid + " " + pname);
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
