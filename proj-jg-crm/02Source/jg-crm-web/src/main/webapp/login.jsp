<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>鲸工</title>
<!-- Bootstrap Core CSS -->
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="static/css/agency.css" rel="stylesheet">
<link rel="stylesheet" href="static/css/login.css" />
<link rel="stylesheet" href="static/css/font-awesome.min.css" />
</head>

<body id="page-top" class="index">
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<a class="navbar-brand page-scroll" href="index.jsp"><img
				class="img_style" src="static/img/public/logo01.png"></a>
		</div>

	</div>
	<!-- /.container-fluid --> </nav>

	<!-- Header -->
	<header>
	<div class="container">
		<div class="login-box">
			<div class="login-title text-center">
				<h1>
					<small>鲸工CRM登录</small>
				</h1>
			</div>
			<div class="login-content ">
				<div class="form">
					<form method="post" action="#">
						<div class="form-group">
							<div class="col-xs-12  ">
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-user"></span></span> <input type="text"
										placeholder="用户名" class="form-control" name="username"
										id="username">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12  ">
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-lock"></span></span> <input type="password"
										placeholder="密码" class="form-control" name="password"
										id="password">
								</div>
							</div>
						</div>
						<div class="form-group form-actions">
							<div class="col-xs-4 col-xs-offset-4 ">
								<a href="###" onclick="sysLogin()">
									<button class="btn btn-sm btn-info" type="button">
										<span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;  登录
									</button>
								</a>
							</div>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>
	</header>

	<!-- 引入底部页面 -->
			<%@ include file="bottom.jsp"%>

	<!-- jQuery -->
	<script src="static/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="static/bootstrap/js/bootstrap.min.js"></script>

</body>
<script language="JavaScript">
	function sysLogin() {
		var jsonStr = {
			name : $("#username").val(),
			password : $("#password").val()
		};
		
		$.ajax({
			type : "post",
			url : "login/userLogin",
			data : jsonStr,
			dataType : "json",
			async : false,
			success : function(data) {
				if(data.name==null){
					alert("无效用户");
				}
				else{
					window.location.href="index.jsp";
				}
			},
			error : function(msg) {
				alert(msg);
			}
		});
	}
</script>

</html>