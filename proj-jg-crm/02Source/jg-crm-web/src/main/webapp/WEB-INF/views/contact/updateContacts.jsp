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
			<%@ include file="/top.jsp"%>

	<!-- Header -->
	<header>
	<div class="container">
<form action="insertContacts" method="post" enctype="multipart/form-data" id="ContactForm">
		<div class="row">
			<div class="col-md-12">
				<div class="crm_panel">
					<span style="margin-right:10px;"> <img style="width: 30px;"
						src="../static/img/index/h-03.png" />
					</span> 
					
					<c:if test="${clist[0].ID==null||clist[0].ID==''}">
					<span style="color: #000; font-weight: bold; font-size: 24px;">创建联系人
					</span>					
					</c:if>
					<c:if test="${clist[0].ID!=null}">
					<span style="color: #000; font-weight: bold; font-size: 24px;">修改联系人
					<input type="hidden" value="${clist[0].GID}"  name="GID" >
					</span>					
					</c:if>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<!-- ./row -->

				<div class="smart-widget">
					<div class="smart-widget-header">
						联系人信息 <span class="smart-widget-option"> <a
							data-toggle="collapse" class="widget-collapse-option" href="#">
								<i class="fa fa-chevron-up"></i>
						</a>
						</span>
					</div>
					<div class="smart-widget-inner table-responsive"
						style="display: block;">
						<div class="form-horizontal m-top-md">
							<div class="form-group">
							<input type="hidden" value="${clist[0].ID}" id="con_ID" name="yID" >
							
								<label class="col-sm-2 control-label">联系人姓名</label>
								<div class="col-sm-3">
									<input type="text"   id="con_name"
										name="name" class="form-control"  value="${clist[0].name}">
								</div>
								<label class="col-sm-2 control-label">性别</label>
								<div class="col-sm-3">
										<select name="gender" class="selectpicker">
											<c:if test="${clist[0].gender==0}">
												<option value="0">男</option>
												<option value="1">女</option>
											</c:if>
											<c:if test="${clist[0].gender==1}">
												<option value="1">女</option>
												<option value="0">男</option>
											</c:if>
											<c:if test="${clist[0].gender==null}">
												<option value="0">男</option>
												<option value="1">女</option>
											</c:if>
										</select>
									</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">职务</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="_position"
										name="position" value="${clist[0].position}">
								</div>
								<label class="col-sm-2 control-label">所属客户</label>
									<div class="col-sm-3">
										<select id="local-area3" id="_region" name="owner"
											class="selectpicker" data-hide-disabled="true"
											data-live-search="true">
											<optgroup>
											 
											<c:forEach items="${list}" var="l">
													<option value="${l.name }"<c:if test="${clist[0].owner==l.name }">selected="selected"</c:if>>${l.name}</option>
											</c:forEach>
											</optgroup>
											
										</select>
									</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">联系电话</label>
								<div class="col-sm-3">
									<input type="text" id="checkphone" class="form-control"
										name="telphone" value="${clist[0].telphone }">
								</div>
								<label class="col-sm-2 control-label">电子邮箱</label>
								<div class="col-sm-3">
									<input type="text" id="email" class="form-control"
										name="email" value="${clist[0].email}">
								</div>
							</div>
								<div class="form-group">
								<label class="col-sm-2 control-label">联系电话2</label>
								<div class="col-sm-3">
									<input type="text" class="form-control"
										name="mobile" value="${clist[0].mobile }">
								</div>
								
							</div>
							</div>
					 

					</div>
					<!-- ./smart-widget-inner -->
				</div>

				<div class="smart-widget">
					<div class="smart-widget-header">
						地址信息 <span class="smart-widget-option"> <a
							data-toggle="collapse" class="widget-collapse-option" href="#">
								<i class="fa fa-chevron-up"></i>
						</a>

						</span>
					</div>
					<div class="smart-widget-inner table-responsive"
						style="display: block;">
						<div id="detailedAddress">
							<div class="form-horizontal m-top-md">
								<div class="form-group">
									<label class="col-sm-2 control-label" id="_addName">详细地址</label>
									<input type="hidden" value="详细地址" name="addName">
									<div class="col-sm-7">
										<input type="text" class="form-control" id="_address"
											name="address" value="${clist[0].address}">
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- ./smart-widget-inner -->
				</div>

				<div class="smart-widget">
					<div class="smart-widget-header">
						描述 <span class="smart-widget-option"> <a
							data-toggle="collapse" class="widget-collapse-option" href="#">
								<i class="fa fa-chevron-up"></i>
						</a>

						</span>
					</div>
					<div class="smart-widget-inner table-responsive"
						style="display: block;">
						<div class="form-horizontal m-top-md">
							<div class="form-group">
								<label class="col-lg-2 control-label">描述</label>
								<div class="col-lg-10">
									<textarea rows="3" class="form-control" id="_desc"
										name="description"  >${clist[0].description}</textarea>
								</div>
								<!-- /.col -->
							</div>
						</div>

					</div>
					<!-- ./smart-widget-inner -->
				</div>
</form>

				<div class="smart-widget-footer">
					<button type="button" class="btn-lg btn-block btn_gh"
						onclick="updateContacts()">保存</button>
					<c:if test="${clist[0]==null||clist[0]==''}">
					<button class="btn btn-primary btn-lg btn-block" type="button" 
					onclick="saveAndCreate()">保存并新建</button>
					</c:if>
					
					<button class="btn btn-cancel btn-lg btn-block" onclick="_cancel()" type="button">取消</button>
				</div>
				<!-- ./smart-widget -->

			</div>
			<!-- ./col -->
			<!-- ./col -->


<form action="refreshPage" id="reForm"></form>
	</header>
		
		<!-- 引入底部页面 -->
			<%@ include file="/bottom.jsp"%>

<script src="../static/js/jquery-1.11.1.min.js"></script>
<script src="../static/bootstrap/js/bootstrap.min.js"></script>
	<!-- Slimscroll -->
	<script src='../static/js/jquery.slimscroll.min.js'></script>

	<!-- Simplify -->
	<script src="../static/js/simplify/simplify.js"></script>

	<script type="text/javascript" src="../static/js/bootstrap-select.min.js"></script>
	 <script type="text/javascript" src="../static/js/contact/updateContacts.js"></script> 
	
</body>
</html>