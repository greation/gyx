<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>鲸工</title>
	
	<!-- Bootstrap Core CSS -->
	<link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom CSS -->
	
	<link rel="stylesheet" href="./../static/css/contact/addContacts.css" />
	<link rel="stylesheet" href="../static/css/font-awesome.min.css" />
	<link rel="stylesheet" href="../static/css/ionicons.min.css" />
	<link rel="stylesheet" href="../static/css/bootstrap-select.min.css" />
	<link href="../static/css/agency.css" rel="stylesheet" />
</head>
<body id="page-top" class="index">

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" href="index.html#page-top"><img
					class="img_style" src="./../static/img/public/logo01.png"></a>
			</div>
	
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li><a class="page-scroll" href="#services">欢迎！用户名</a></li>
					<li><a class="page-scroll" href="#portfolio">信息（<span
							style="color: #ff0000;">200</span>）
					</a></li>
					<li><a class="page-scroll" href="login.html#page-top">退出</a></li>
					<li><a class="page-scroll" href="index.html#page-top">返回首页</a>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> 
	</nav>
	<form action="custAdd" id="saveForm" method="post" enctype="multipart/form-data">
		<!-- Header -->
		<header>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="crm_panel">
							<span style="margin-right: 10px;">
								<img src="./../static/img/index/h-02.png" />
							</span>
							<span class="addC">创建客户</span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="smart-widget">
							<div class="smart-widget-header">
								<span>客户信息 </span>
								<span class="fileInputContainer">
								    <input class="fileInput" type="file" name="" id="" />
								</span>
								<span class="smart-widget-option">
									<a data-toggle="collapse" class="widget-collapse-option" href="#">
										<i class="fa fa-chevron-up"></i>
									</a>
								</span>
							</div>
							<div class="smart-widget-inner table-responsive">
								<div class="form-horizontal m-top-md" style="float: left; width: 50%;">
									<div class="form-group">
										<label class="col-sm-3 control-label">客户名称</label>
										<div class="col-sm-9">
											<input type="text" value="Jane Doe" id="_custName" name="name"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">注册资金</label>
										<div class="col-sm-9">
											<input type="text" id="_capital" name="capital" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">联系人</label>
										<div class="col-sm-9">
											<input type="text" id="_conname" name="conname" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">传真</label>
										<div class="col-sm-9">
											<input type="text" id="_faxes" name="faxes"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">客户级别</label>
										<div class="col-sm-9">
											<select id="classification" id="_level" name="level" class="selectpicker">
												<option value="1">1级</option>
												<option value="2">2级</option>
												<option value="3">3级</option>
												<option value="4">4级</option>
												<option value="5">5级</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">公司性质</label>
										<div class="col-sm-9">
											<select id="nature-of-company" class="selectpicker" name="corpKind" data-hide-disabled="true" data-live-search="true">
												<optgroup>
													<option value="0">公司性质</option>
													<c:forEach items="${corpKindList}" var="clist">
														<option value="${clist.code }">${clist.caption}</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">所在行业</label>
										<div class="col-sm-9">
											<select id="nature-of-company" class="selectpicker" name="industry" data-hide-disabled="true" data-live-search="true">
												<optgroup>
													<option value="0">所在行业</option>
													<c:forEach items="${industryList}" var="inlist">
														<option value="${inlist.code }">${inlist.caption}</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
								</div>
								<div class="form-horizontal m-top-md" style="float: right; width: 50%;">
									<div class="form-group">
										<label class="col-sm-3 control-label">法人</label>
										<div class="col-sm-9">
											<input type="text" id="_legal" name="legal"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">所在地区</label>
										<div class="col-sm-9">
											<select id="local-area3" name="region" class="selectpicker" data-hide-disabled="true" data-live-search="true">
												<optgroup>
													<option value="0">所在地区</option>
													<c:forEach items="${regionList}" var="clist">
														<option value="${clist.code }">${clist.caption}</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">联系电话</label>
										<div class="col-sm-9">
											<input type="text" id="_telphone" name="telphone"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">客户分类</label>
										<div class="col-sm-9">
											<select id="classification" id="_classification"
												name="classification" class="selectpicker">
												<option value="1">源生</option>
												<option value="2">跟踪中</option>
												<option value="3">洽谈</option>
												<option value="4">签约</option>
												<option value="5">黑名单</option>
											</select>
										</div>
									</div>
									<div class="form-group">
	
										<label class="col-sm-3 control-label">客户类型</label>
										<div class="col-sm-9">
											<select id="classification" id="_custType" name="custType"
												class="selectpicker">
												<option value="1">供应商</option>
												<option value="2">采购商</option>
	
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">渠道来源</label>
										<div class="col-sm-9">
											<select id="_Industry" class="selectpicker" data-hide-disabled="true" name="channel" data-live-search="true">
												<optgroup>
													<option value="0">渠道来源</option>
													<c:forEach items="${channelList}" var="chlist" >
													<option value="${chlist.code }">${chlist.caption}</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">所属用户</label>
										<div class="col-sm-9">
											<select id="nature-of-company" class="selectpicker" name="owner" data-hide-disabled="true" data-live-search="true">
												<optgroup>
													<option value="${user.ID }">自己</option>
													<option value="">无</option>
												</optgroup>
											</select>
										</div>
									</div>
									
									
								</div>
							</div>
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
											<label class="control-label" style="float: left;">详细地址</label>
											<input type="hidden" name="addressList[0].name" value="详细地址" />
											<div class="col-sm-10">
												<input type="text" class="form-control" name="addressList[0].address">
											</div>
										</div>
									</div>
								</div>
								<button onclick="addAddress()" class="btn btn-default addcus2"
									type="button">
									<span style="color: #0074C1;">+</span>添加地址
								</button>
							</div>
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
										<label class="control-label" style="float: left;">描述</label>
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
							<button type="button" onclick="savaCustomer()" class="btn-lg btn-block btn_gh">保存</button>
							<button class="btn btn-primary btn-lg btn-block" onclick="savaAndCreateCustomer()" type="button">保存并新建</button>
							<button class="btn btn-cancel btn-lg btn-block" onclick="javascript:history.go(-1)" type="button">取消</button>
						</div>
					</div>
				</div>
			</div>
		</header>
	</form>
	<footer>
		<div class="container">
			<div class="hrdiv"></div>
			<div class="row">
				<div class="col-md-4">
					<span class="copyright">帮助中心：<a>关于我们</a>|<a>隐私申明</a>|<a>用户规则</a></span>
				</div>
				<div class="col-md-4">
					<span class="copyright">24小时全国服务热线：<span
						style="color: #AC2925;">400-6566-777</span></span>
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
		src="../static/js/customer/addCusomer.js"></script>
	<script type="text/javascript">
		
	</script>
</body>

</html>