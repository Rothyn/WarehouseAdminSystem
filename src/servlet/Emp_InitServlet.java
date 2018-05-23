package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Employee;

import dao.EmployeeDao;

public class Emp_InitServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		EmployeeDao edao = new EmployeeDao();
		HashMap<String,Employee> allemp = null;
		try {
			allemp = edao.getAllEmps();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("allemp", allemp);
		try {
			response.sendRedirect("/JavaPrj/manage_emp.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
