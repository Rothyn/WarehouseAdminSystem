package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Product;

import dao.ProductDao;

public class PrdInit extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		ProductDao pdao = new ProductDao();
		HashMap allprd = null;
		try {
			allprd = pdao.getAllPrds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("allprd", allprd);
		try {
			response.sendRedirect("/JavaPrj/mainPrd.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
