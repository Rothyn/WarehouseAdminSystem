<%@ page language="java" import="java.util.*" pageEncoding="gb2312" %>
<%@ page import="dao.ProductDao"%>
<%@ page import="vo.Product"%>
<script type="text/javascript">
function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){          
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	}
}

window.onload=function(){
	altRows('alternatecolor');
}
</script>
<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
body {
        background-color: #f1f1f1;
      }
table.altrowstable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}
table.altrowstable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
.oddrowcolor{
	background-color:#d4e3e5;
}
.evenrowcolor{
	background-color:#c3dde0;
}

</style>
<html>
<title>产品管理</title>
	<body align="center">
	<h1>产品管理</h1>
	<form action="prdinit" method="post">
		
		<%
			//HashMap allprd=(HashMap)session.getAttribute("allprd");
			ProductDao edao = new ProductDao();
			HashMap allprd=edao.getAllPrds();
		%>
		<table  class="altrowstable" id="alternatecolor" align="center">
		<tr>
		<th>产品号</th>
		<th>产品名称</th>
		<th>价格</th>
		<th>数量</th>
		<th>供货商</th>
		<th>入库时间</th>
		<th></th>
		<th></th>
		</tr>
		<%
			//System.out.println(allprd);
			Set set=allprd.keySet();
			Iterator ite=set.iterator();
			while(ite.hasNext()){
				String pid=(String)ite.next();
				Product prd=(Product)allprd.get(pid);
		%>
			<tr>
			<td><%= prd.getPid()%></td>
			<td><%= prd.getPname()%></td>
			<td><%= prd.getPrice()%></td>
			<td><%= prd.getPnumber()%></td>
			<td><%= prd.getSupplier()%></td>
			<td><%= prd.getIntime()%></td>
			<td><a href="updatePrd.jsp?pid=<%= pid %>">修改</a></td>
			<td><a href="delprd?pid=<%= pid %>">删除</a></td>
			</tr>
		<%} %>
		</table>
		<br/><a href="addNewPrd.jsp">增加新的产品</a><br/>
		</form>
		<a href="main.jsp">返回</a>
	</body>
</html>