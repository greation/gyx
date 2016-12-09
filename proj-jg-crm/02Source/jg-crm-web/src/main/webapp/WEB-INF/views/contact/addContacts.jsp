<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>鲸工</title>

<!-- Bootstrap Core CSS -->
<link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->

<link rel="stylesheet" href="../static/css/contact/addContacts.css" />
<link rel="stylesheet" href="../static/css/font-awesome.min.css" />
<link rel="stylesheet" href="../static/css/ionicons.min.css" />
<link rel="stylesheet" href="../static/css/bootstrap-select.min.css" />
<link href="../static/css/agency.css" rel="stylesheet">

</head>
<body id="page-top" class="index">
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" href="index.html#page-top">
					<img class="img_style" src="../static/img/public/logo01.png">
				</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li><a class="page-scroll" href="#services">欢迎！用户名</a></li>
					<li><a class="page-scroll" href="#portfolio">信息（<span style="color: #ff0000;">200</span>） </a></li>
					<li><a class="page-scroll" href="login.html#page-top">退出</a></li>
					<li><a class="page-scroll" href="index.html#page-top">返回首页</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<form action="insertContacts" method="post" enctype="multipart/form-data" id="saveContact">
	<!-- Header -->
	<header>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="crm_panel">
					<span style="margin-right: 10px;">
						<img src="./../static/img/index/09.png" />
					</span>
					<span class="addC">创建联系人</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<!-- ./row -->
				<div class="smart-widget">
					<div class="smart-widget-header">
						<span>联系人信息 </span>
						<span class="smart-widget-option">
							<a data-toggle="collapse" class="widget-collapse-option" href="#">
								<i class="fa fa-chevron-up"></i>
							</a>
						</span>
					</div>
					<div class="smart-widget-inner table-responsive">
						<div class="form-horizontal m-top-md" style="float: left; width: 50%;">
							<div class="form-group">
								<label class="col-sm-3 control-label">联系人姓名</label>
								<div class="col-sm-9">
									<input type="text"  id="con_name" name="name" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">职务</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="_position" name="position">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">联系电话</label>
								<div class="col-sm-9">
									<input type="text" id="checkphone" class="form-control" name="telphone">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">电子邮箱</label>
								<div class="col-sm-9">
									<input type="text" id="email" name="email" class="form-control">
								</div>
							</div>
						</div>
						<div class="form-horizontal m-top-md" style="float: right; width: 50%;">
							<div class="form-group">
								<label class="col-sm-3 control-label">性别</label>
								<div class="col-sm-9">
									<select name="gender" class="selectpicker">
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">称呼</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="_title" name="title">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">所属客户</label>
								<div class="col-sm-9">
									<select data-live-search="true" data-hide-disabled="true" class="selectpicker bs-select-hidden" id="nature-of-company" name="owner">
										<optgroup>
											<option id="o_wner" hidden="true" value="0"> </option>
											<c:forEach items="${list}" var="l">
												<option>${l}</option>
											</c:forEach>
										</optgroup>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">&nbsp;</label>
								<div class="col-sm-9">
									<input style="visibility: hidden;" type="text"  class="form-control">
								</div>
							</div>
						</div>
					</div>
					<!-- ./smart-widget-inner -->
				</div>
				<div class="smart-widget">
					<div class="smart-widget-header">
						<span>
							地址信息 
						</span>
						<span class="smart-widget-option">
							<a data-toggle="collapse" class="widget-collapse-option" href="#">
								<i class="fa fa-chevron-up"></i>
							</a>
						</span>
					</div>
					<div class="smart-widget-inner table-responsive">
						<div id="detailedAddress">
							<div class="form-horizontal m-top-md">
								<div class="form-group">
									<label class="control-label" style="float: left;" id="_addName">详细地址</label>
									<input type="hidden" name="addName" value="详细地址" />
									<div class="col-sm-10">
										<input type="text" class="form-control" id="_address" name="address">
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- ./smart-widget-inner -->
				</div>
				<div class="smart-widget">
					<div class="smart-widget-header">
						描述 <span class="smart-widget-option">
						<a data-toggle="collapse" class="widget-collapse-option" href="#">
							<i class="fa fa-chevron-up"></i>
						</a>
						</span>
					</div>
					<div class="smart-widget-inner table-responsive">
						<div class="form-horizontal m-top-md">
							<div class="form-group">
								<label class="control-label"  style="float: left;">描述</label>
								<div class="col-lg-11">
									<textarea rows="3" class="form-control" id="_desc" name="description"></textarea>
								</div>
								<!-- /.col -->
							</div>
						</div>
					</div>
					
					<!-- ./smart-widget-inner -->
				</div>
				<div class="smart-widget-footer">
					<button type="button"  class="btn-lg btn-block btn_gh" onclick="saveContacts()">保存</button>
					<button class="btn btn-primary btn-lg btn-block" type="button" onclick="saveAndCreateContacts()">保存并新建</button>
					<button class="btn btn-cancel btn-lg btn-block" onclick="_cancel()" type="button">取消</button>
				</div>
				<!-- ./smart-widget -->
			</div>
		</div>
	</div>
	</header>
	</form>
	
	<form action="refreshPage" id="reForm"></form>
	
	<footer>
		<div class="container">
			<div class="hrdiv"></div>
			<div class="row">
				<div class="col-md-4">
					<span class="copyright">帮助中心：<a>关于我们</a>|<a>隐私申明</a>|<a>用户规则</a></span>
				</div>
				<div class="col-md-4">
					<span class="copyright">24小时全国服务热线：<span style="color: #AC2925;">400-6566-777</span></span>
				</div>
			</div>
			<div class="hrdiv"></div>
			<div class="row">
				<div class="col-md-8">
					<span class="copyright"><p>Copyright 2005-2016
							鲸工工业品交易服务平台 版权所有,并保留所有权利</p></span>
				</div>
			</div>
		</div>
	</footer>
	<!-- jQuery -->
	<script src="../static/js/jquery-1.11.1.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../static/bootstrap/js/bootstrap.min.js"></script>

	<!-- Slimscroll -->
	<script src='../static/js/jquery.slimscroll.min.js'></script>

	<!-- Simplify -->
	<script src="../static/js/simplify/simplify.js"></script>

	<script type="text/javascript"
		src="../static/js/bootstrap-select.min.js"></script>
	<script type="text/javascript"
		src="../static/js/contact/addContacts.js"></script>

</body>
</html>