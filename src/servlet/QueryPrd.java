package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrdSql;

public class QueryPrd extends HttpServlet {

	private PrdSql sql = null;
	private final static String s1 = "<h1>请输入需要搜索的产品号或者名称：</h1><form action='queryprd' method='post'>  "
			+ "&nbsp;&nbsp;&nbsp;点击查询:<input type='text' name='mess'/>&nbsp;&nbsp;"
			+ "<input type='submit' value='提交' name='sub'/>" + "&nbsp;&nbsp;<a href= \"main.jsp\" >返回</a></form><br/>";

	public QueryPrd() throws Exception {
		super();
		sql = new PrdSql(); // 进行数据库访问的类
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter pw = response.getWriter();

		String sub = request.getParameter("sub");

		pw.println(s1);
		String mess = request.getParameter("mess");

		if (mess != null && mess.length() > 0) {
			try {
				String s = sql.getMess(mess);
				String mess_str[] = s.split(",");
				String html = " <table border='5'>" + "<tr>" + "<th>产品号</th>"
						+ "<th>产品名称</th>" + "<th>产品价格</th>" + "<th>产品数量</th>"
						+ "<th>供货商</th>" + "<th>入库时间</th>";
				String main = "<tr>" + "<td>" + mess_str[0] + "</td>" + "<td>"
						+ mess_str[1] + "</td>" + "<td>" + mess_str[2]
						+ "</td>" + "<td>" + mess_str[3] + "</td>" + "<td>"
						+ mess_str[4] + "</td>" + "<td>" + mess_str[5]
						+ "</td></tr></table>";
				
				String head = html + main;
//				System.out.println(head);
				pw.println(head);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}