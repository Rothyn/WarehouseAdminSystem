<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<title>Login</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<meta name="keywords"
			content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<!--webfonts-->
		<link
			href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700'
			rel='stylesheet' type='text/css'>
		<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet'
			type='text/css'>
		<!--//webfonts-->
		<script src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	</head>
	<body>
		<script>
	$(document).ready(function(c) {
		$('.close').on('click', function(c) {
			$('.login-form').fadeOut('slow', function(c) {
				$('.login-form').remove();
			});
		});
	});
</script>
		<!--SIGN UP-->
		<h1>
			仓库管理系统登录
		</h1>
		<form action="login" method="post">
		<div class="login-form">
			<div class="close">
			</div>
			<div class="head-info">
				<label class="lbl-1">
				</label>
				<label class="lbl-2">
				</label>
				<label class="lbl-3">
				</label>
			</div>
			<div class="clear">
			</div>
			<div class="avtar">
				<img src="images/avtar.png" />
			</div>
			
				<input type="text" class="text" value="ID" name="eid"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'ID';}">
				
				<div class="key">
					<input type="password" value="Password" name="password" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Password';}">
				</div>
							<%
					String info = (String)request.getAttribute("login_err");
				 %>
				<span style="color:white;"><%=(info == null ? "" : info)%></span>
			<div class="signin">
				<input type="submit" value="Login">
			</div>
		</div>
		<div class="copy-rights">
			<p>
				Copyright &copy; 2017.Company name All rights reserved.
			</p>
		</div>
	</form>
	</body>
</html>