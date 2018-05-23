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

public class EmpAdd extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("gb2312");
		//获取提交的内容
		String eid= request.getParameter("eid");
		String password = request.getParameter("password");
		String ename = request.getParameter("ename");
		String sex = request.getParameter("sex");
		int eage = Integer.parseInt(request.getParameter("eage"));
		int salary =Integer.parseInt(request.getParameter("salary"));
		String ismanager = request.getParameter("ismanager");
		String tel = request.getParameter("tel");
		
		Connection conn=null;
		conn = DBUtil.getConnection();
		try {
			PreparedStatement prep = conn.prepareStatement(
					"insert into t_emp(eid,password,ename,sex,eage,salary,ismanager,tel) " 
					+ "values(?,?,?,?,?,?,?,?)");
			prep.setString(1, eid);
			prep.setString(2, password);
			prep.setString(3, ename);
			prep.setString(4, sex);
			prep.setInt(5, eage);
			prep.setInt(6, salary);
			prep.setString(7, ismanager);
			prep.setString(8, tel);
			prep.executeUpdate();
			
//			response.sendRedirect("manage_emp.jsp");
//			System.out.println("add:"+eid+" "+ename);
			response.sendRedirect("manage_emp.jsp");
//			request.getRequestDispatcher("manage_emp.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
