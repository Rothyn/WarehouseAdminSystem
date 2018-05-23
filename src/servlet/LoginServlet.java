package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Employee;
import dao.EmployeeDao;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("gb2312");
		request.setCharacterEncoding("utf-8");
		String eid=request.getParameter("eid");
		String password = request.getParameter("password");
		EmployeeDao edao = new EmployeeDao();
		HashMap allemp = null;
		Employee emp = null;
		try {
			allemp = edao.getAllEmps();
			emp=(Employee)allemp.get(eid);
			if(emp!=null&&emp.getPassword().equals(password)){
				HttpSession session = request.getSession();
				session.setAttribute("emp", emp);
				response.sendRedirect("main.jsp");
			}else{
				request.setAttribute("login_err", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
		}
		
	}
}
