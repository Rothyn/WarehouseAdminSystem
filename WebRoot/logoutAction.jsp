<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<html>
	<body>	
		<%
			session.invalidate();
			response.sendRedirect("login.jsp");
		%>
	</body>
</html>