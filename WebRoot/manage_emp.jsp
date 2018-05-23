<%@ page language="java" import="java.util.*" pageEncoding="gb2312" %>
<%@ page import="vo.Employee"%>
<%@ page import="dao.EmployeeDao"%>
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
<title>���¹���</title>
	<body align="center">
	<h1>���¹���</h1>
	<form action="empinit" method="post">
		
		<%
			//HashMap allemp=(HashMap)session.getAttribute("allemp");
			EmployeeDao edao = new EmployeeDao();
			HashMap allemp=edao.getAllEmps();
		%>
		<table  class="altrowstable" id="alternatecolor" align="center">
		<tr>
		<th>Ա����</th>
		<th>����</th>
		<th>����</th>
		<th>�Ա�</th>
		<th>����</th>
		<th>����</th>
		<th>�Ƿ�Ϊ�����</th>
		<th>�绰</th>
		<th></th>
		<th></th>
		</tr>
		<%
			//System.out.println(allbook);
			Set set=allemp.keySet();
			Iterator ite=set.iterator();
			while(ite.hasNext()){
				String eid=(String)ite.next();
				Employee emp=(Employee)allemp.get(eid);
		%>
			<tr>
			<td><%= emp.getEid()%></td>
			<td><%= emp.getPassword()%></td>
			<td><%= emp.getEname()%></td>
			<td><%= emp.getSex()%></td>
			<td><%= emp.getEage()%></td>
			<td><%= emp.getSalary()%></td>
			<td><%= emp.getIsmanager()%></td>
			<td><%= emp.getTel()%></td>
			<td><a href="updateEmp.jsp?eid=<%= eid %>">�޸�</a></td>
			<td><a href="delemp?eid=<%= eid %>">ɾ��</a></td>
			</tr>
		<%} %>
		</table>
		<br/>
		<a href="addNewEmp.jsp">�����µ�Ա��</a><br/><br/>
		<a href="main.jsp">����</a>
		</form>
	</body>
</html>