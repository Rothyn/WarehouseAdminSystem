package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

public class PrdAdd extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		// 获取提交的内容
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		int pnumber = Integer.parseInt(request.getParameter("pnumber"));
		String supplier = request.getParameter("supplier");
		String intime = request.getParameter("intime");
		Connection conn = null;
		conn = DBUtil.getConnection();
		try {
			PreparedStatement prep = conn.prepareStatement(
							"insert into t_prd(pid,pname,price,pnumber,supplier,intime) "
							+ "values(?,?,?,?,?,?)");
			prep.setString(1, pid);
			prep.setString(2, pname);
			prep.setString(3, price);
			prep.setInt(4, pnumber);
			prep.setString(5, supplier);
			prep.setString(6, intime);
			prep.executeUpdate();
//			System.out.println("add:" + pid + " " + pname);
			response.sendRedirect("mainPrd.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
