<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom CSS -->
		<link rel="stylesheet" href="./../static/css/contact/addContacts.css" />
		<!-- <link rel="stylesheet" href="../static/css/contact/contactsDetail.css" /> -->
		<link rel="stylesheet" href="../static/css/customer/customerDetail.css" />
		<link rel="stylesheet" href="../static/css/font-awesome.min.css" />
		<link rel="stylesheet" href="../static/css/ionicons.min.css" />
		<link rel="stylesheet" href="../static/css/bootstrap-select.min.css" />
		<link href="../static/css/agency.css" rel="stylesheet">
</head>
		<body id="page-top" class="index">
			<!-- 引入头部页面 -->
			<%@ include file="/top.jsp"%>

			<!-- Header -->
			<header style="min-height: 880px !important;">
				<div class="container bg_S">

					<div class="row">
					<div class="bg_P">
						<img alt="" src="./../static/img/index/009.png">
					</div>
						<div class="col-md-12">
							<div class="crm_panel">
								<span style="margin-right: 10px;">
									<img src="../static/img/index/09.png"/>
								</span>
								<span class="addC">联系人详细资料</span>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<!-- ./row -->

							<div class="smart-widget">
								<div class="smart-widget-header">
									<span>客户信息</span>
									<span class="smart-widget-option">									
										<a data-toggle="collapse" class="widget-collapse-option" href="#">
											<i class="fa fa-chevron-up"></i>
										</a>
									</span>
								</div>
								<div class="smart-widget-inner table-responsive">
									<form class="form-horizontal m-top-md">
										<div class="form-group">
											<label class="col-sm-2 control-label">联系人姓名</label>
											<div class="col-sm-3">
												${contact.name}
											</div>
											
											<label class="col-sm-2 control-label">性别</label>
											<div class="col-sm-3">
												<c:choose>
												   <c:when test="${contact.gender==0}">男</c:when>  
												   <c:otherwise>女 </c:otherwise> 
												</c:choose>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">职位</label>
											<div class="col-sm-3">
												${contact.position}
											</div>
											
											<label class="col-sm-2 control-label">所属客户</label>
											<div class="col-sm-3">
											${contact.owner }
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">联系电话</label>
											<div class="col-sm-3">
												${contact.telphone}
											</div>
											
											<label class="col-sm-2 control-label">联系电话2</label>
											<div class="col-sm-3">
												${contact.mobile}
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 control-label">创建人</label>
											<div class="col-sm-3">
												${contact.generalName}
											</div>
											
											<label class="col-sm-2 control-label">创建时间</label>
											<div class="col-sm-3">
											<fmt:formatDate value="${contact.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>  
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 control-label">地址信息</label>
											<div class="col-sm-9">${contact.address}</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 control-label">描述</label>
											<div class="col-sm-9">${contact.description}</div>
										</div>
										
									</form>
								</div>
								<!-- ./smart-widget-inner -->
							</div>

							
							
							<div class="smart-widget">
								<div class="smart-widget-header">
									历史记录
									<span class="smart-widget-option">			
									<a data-toggle="collapse" class="widget-collapse-option" href="#">
										<i class="fa fa-chevron-up"></i>
									</a>
									</span>
								</div>
								<div class="smart-widget-inner table-responsive" style="display: block;">
									<div class="describe w100">
										<div class="col-lg-9 describe-box describe-T">
											<table class="table table-striped">
											   <thead>
											      <tr>
											         <th>操作</th>
											         <th>更改内容</th>
											         <th>操作人</th>
											         <th>操作时间</th>
											      </tr>
											   </thead>
											   <tbody>
											   <c:forEach items="${pastList}" var="p">
											      <tr>
											         <td><c:if test="${p.action==1}">更新</c:if><c:if test="${p.action==0}">新增</c:if></td>
											         
											         <td style="text-align:left">${p.text}</td>
											         <td>${p.creator}</td>
											         <td><fmt:formatDate value="${p.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
											      </tr>
											      </c:forEach>
											   </tbody>
											</table>
										</div>
									</div>
								</div>
								<!-- ./smart-widget-inner -->
							</div>
								<div class="smart-widget-footer">
										<button type="button" class="btn-lg btn-block btn_gh edit_S" onclick="editFun()">编辑</button>
										<button class="btn btn-cancel btn-lg btn-block edit_S" type="button" onclick="rebackFun()">返回</button>
									</div>
							<!-- ./smart-widget -->
						</div>
						<!-- ./col -->
					</div>
				</div>
			</header>

			<!-- 引入底部页面 -->
			<%@ include file="/bottom.jsp"%>

			<!-- Slimscroll -->
			<script src='../static/js/jquery.slimscroll.min.js'></script>

			<!-- Simplify -->
			<script src="../static/js/simplify/simplify.js"></script>

			<script type="text/javascript" src="../static/js/bootstrap-select.min.js"></script>

		</body>
<script language="JavaScript">
	function editFun() {
		window.location.href="searchContsByID?ID=${contact.ID}";
	}
	function rebackFun() {
		window.history.go(-1);
	}
	
</script>
</html>
