<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="vo.Employee" %>
<html>
<style>
	form{ height:100px; width:500px; border:900px solid #666666;}
</style>
	<head>
	<title>main</title>
		<!-- Theme style  -->
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div class="display-tc animate-box">
			<br />
			<br />
			<form action="prdinit" method="post">
				<input type="submit" value="进出货管理">
			</form>
			<form action="queryprd" method="post">
				<input type="submit" value="库存查询" />
			</form>
			<% 
				Employee emp=(Employee)session.getAttribute("emp");
				if(emp.getIsmanager().equals("y")==true){
			 %>
			<form action="empinit" method="post">
				<input type="submit" value="人事管理">
			</form>
			<%} %>
			<form action="logoutAction.jsp" method="post">
				<input type="submit" value="退出登录">
			</form>
		</div>
	</body>
</html>

