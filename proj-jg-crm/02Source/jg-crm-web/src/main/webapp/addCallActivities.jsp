<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
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
		<link href="./static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom CSS -->

		<!--<link rel="stylesheet" href="css/addContacts.css" />-->
		<link rel="stylesheet" href="./static/css/customerActive/addCallActivities.css" />
		<link rel="stylesheet" href="./static/css/font-awesome.min.css" />
		<link rel="stylesheet" href="./static/css/ionicons.min.css" />
		<link rel="stylesheet" href="./static/css/bootstrap-select.min.css" />
		<link href="./static/css/agency.css" rel="stylesheet">
		<link href="./static/css/jeDate/jedate.css" rel="stylesheet">
		<link href="./static/css/jeDate/jeui.css" rel="stylesheet">
		<link href="./static/css/jeDate/prism.css" rel="stylesheet">
		<link href="./static/css/jeDate/gray.css" rel="stylesheet">
		<link href="./static/css/jeDate/green.css" rel="stylesheet">
		<body id="page-top" class="index">

			<!-- Navigation -->
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header page-scroll">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand page-scroll" href="index.html#page-top"><img class="img_style" src="./static/img/public/logo01.png"></a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">
							<li class="hidden">
								<a href="#page-top"></a>
							</li>
							<li>
								<a class="page-scroll" href="#services">欢迎！用户名</a>
							</li>
							<li>
								<a class="page-scroll" href="#portfolio">信息（<span style="color: #ff0000;">200</span>）</a>
							</li>
							<li>
								<a class="page-scroll" href="login.html#page-top">退出</a>
							</li>
							<li>
								<a class="page-scroll" href="index.html#page-top">返回首页</a>
							</li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>

			<!-- Header -->
			<header>
				<div class="container">

					<div class="row">
						<div class="col-md-12">
							<div class="crm_panel">
								<span style="margin-right: 10px;">
									<img style="width: 30px;" src="./static/img/index/h-03.png"/>
								</span>
								<span style="color: #000; font-weight: bold; font-size: 24px;">创建客户</span>
								<button class="btn btn-default" style="margin: 0 0 10px 2%;" type="button"><span style="color: #0074C1;">+</span>添加客户</button>
							</div>
						</div>
					</div>

					<div class="row">
					<form class="form-horizontal m-top-md" action="actionRecord/saveActionRecords" method="post" enctype="multipart/form-data">
						<div class="col-lg-12">
							<!-- ./row -->

							<div class="smart-widget">
								<div class="smart-widget-header">
									客户信息
									
									<span class="smart-widget-option">
																			
									<a data-toggle="collapse" class="widget-collapse-option" href="#">
										<i class="fa fa-chevron-up"></i>
									</a>
									
									</span>
								</div>
								<div class="smart-widget-inner table-responsive" style="display: block;">
									
										<div class="form-group">
											<label class="col-sm-2 control-label">客户名称</label>
											<div class="col-sm-3">
												<input type="text" value="**公司" name="actionrecord.cusName" id="cusName" class="form-control" onblur="isCustomer()">
											</div>

											<label class="col-sm-2 control-label">联系人</label>
											<div class="col-sm-3">
												<input type="text" class="form-control" id="recepter"  name="actionrecord.recepter" onblur="queryPhoneNoByCusNameandTname()">
											</div>
										</div>
										
										
										<div class="form-group">
											<label class="col-sm-2 control-label">联系电话</label>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="actionrecord.rcptPhone">
											</div>

											<label class="col-sm-2 control-label">方式</label>
											<div class="col-sm-3">
												<div>
													<input class="methed" type="radio" name="actionrecord.methed" value="0" />当面拜访
													<input class="methed"  type="radio" name="actionrecord.methed" value="1" checked="checked" />电话拜访
													<input class="methed" type="radio" name="actionrecord.methed" value="2" />市场活动
												</div>
											</div>
												
											
										</div>
										
										
										<div class="form-group">
											
											<label class="col-sm-2 control-label">开始时间</label>
											<div class="col-sm-3">
												<input type="text" class="workinput wicon mr25" id="inpstart" name="actionrecord.beginTime" readonly>
											</div>

											<label class="col-sm-2 control-label">结束时间</label>
											<div class="col-sm-3">
												<input type="text" class="workinput wicon mr25" id="inpend" name="actionrecord.endTime" readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">职称</label>
											<div class="col-sm-3">
												<input type="text" value="采购员" class="form-control" name="actionrecord.rcptTitle">
											</div>
										
										</div>
										
										
										<div class="fileStyle">
											<input class="fileStyle-box" type="file" name="uploadFile0" />
										</div>

										<button class="btn btn-default addcus3" type="button" onclick="fileFunction()"><span style="color: #0074C1;">+</span>添加图片</button>

								</div>
								<!-- ./smart-widget-inner -->
							</div>
							<div class="smart-widget">
								<div class="smart-widget-header">
									拜访描述
									<span class="smart-widget-option">
																			
									<a data-toggle="collapse" class="widget-collapse-option" href="#">
										<i class="fa fa-chevron-up"></i>
									</a>
									
									</span>
								</div>
								<div class="smart-widget-inner table-responsive" style="display: block;">
									<form class="form-horizontal m-top-md">
										<div class="form-group">
										<label class="col-lg-2 control-label">描述</label>
										<div class="col-lg-10">
											<textarea rows="3" class="form-control"></textarea>
										</div><!-- /.col -->
									</div>
									</form>

								</div>
								<!-- ./smart-widget-inner -->
							</div>

							
								<div class="smart-widget-footer">
										<button type="submit" class="btn-lg btn-block btn_gh">保存</button>
										<button class="btn btn-primary btn-lg btn-block" type="button">保存并新建</button>
										<button class="btn btn-cancel btn-lg btn-block" type="button">取消</button>
									</div>
							<!-- ./smart-widget -->
						</div>
						<!-- ./col -->
						<!-- ./col -->
						
						</form>
					</div>

				</div>
			</header>

			<footer>
				<div class="container">
					<div class="hrdiv"></div>
					<div class="row">
						<div class="col-md-4">
							<span class="copyright">帮助中心：<a>关于我们</a>|<a>隐私申明</a>|<a>用户规则</a></span>
						</div>
						<div class="col-md-3">
							<span class="copyright">24小时全国服务热线：<span style="color: #AC2925;">400-6566-777</span></span>
						</div>

					</div>
					<div class="hrdiv"></div>
					<div class="row">
						<div class="col-md-8">
							<span class="copyright"><p>Copyright 2005-2016 鲸工工业品交易服务平台 版权所有,并保留所有权利　</p></span>
						</div>
					</div>
				</div>
			</footer>
			<!-- jQuery -->
			<script src="./static/js/jquery-1.11.1.min.js"></script>

			<!-- Bootstrap Core JavaScript -->
			<script src="./static/bootstrap/js/bootstrap.min.js"></script>

			<!-- Slimscroll -->
			<script src='./static/js/jquery.slimscroll.min.js'></script>

			<!-- Simplify -->
			<script src="./static/js/simplify/simplify.js"></script>

			<script type="text/javascript" src="./static/js/bootstrap-select.min.js"></script>
			
			<script type="text/javascript" src="./static/js/jeDate/jedate.js"></script>
			
			<script type="text/javascript" src="./static/js/jeDate/prism.js"></script>
			
			<script type="text/javascript" src="./static/js/jeDate/dateReady.js"></script>
			
			<script type="text/javascript" src="./static/js/customerActive/addCallActivities.js"></script>

		</body>

</html>