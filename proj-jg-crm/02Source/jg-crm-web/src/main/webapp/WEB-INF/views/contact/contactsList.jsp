<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<link href="../static/css/agency.css" rel="stylesheet">
<link rel="stylesheet" href="../static/css/contact/contactsList.css" />
<link rel="stylesheet" href="../static/css/bootstrap-select.min.css" />
</head>
<body id="page-top" class="index" onload="onload()">

	<!-- Navigation -->
		  <%@ include file="/top.jsp"%>

	<!-- Header -->
	<header>
	<div class="container">

		<div class="row">
			<form method="post" action="../Cust/findContactInfo.do">
				<div class="col-md-12">
					<div class="crm_panel">

						<div class="input-group" style="width: 27%">
							<input type="text" class="form-control" placeholder="公司名称搜索"
								name="name">
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
                        <a href="../contact/searchContsByID">
							<span class="addcus" style="border-radius: 5px; border: 1px solid #ddd;">
								<button type="button" class="btn btn-default addcus2">
									<span style="color: #0074C1;">+</span>添加联系人
								</button>
							</span>
						</a>
					</div>
				 
				</div>
			</form>
		</div>

		<div class="row">
			<c:forEach items="${contacts}" var="user" varStatus="vs">
				<div class="col-lg-4">
					<div class="smart-widget widget-purple">
						<div class="smart-widget-header">
							<div class="comlogo"></div>
						</div>
						<div class="smart-widget-inner">

							<div class="smart-widget-body">
								<div>
									<div>
										<a href="../contact/searchContactDetail?contactID=${user.ID}"> <span class="sea_header">
												${user.lname}(<c:if test="${user.gender==0}">先生</c:if> <c:if
													test="${user.gender==1}">女士</c:if>)
										</span>
										</a>
									</div>

									<div class="contdiv">
										<li><span><c:if test="${user.telphone==null||user.telphone==''}">暂无电话</c:if>
										          <c:if test="${user.telphone!=null&&user.telphone!=''}"> ${user.telphone}</c:if>
										         </span></li>
										<li><span><c:if test="${user.email==null||user.email==''}">暂无邮箱</c:if>
                                                  <c:if test="${user.email!=null&&user.email!=''}"> ${user.email}</c:if></span></li>

										<li class="addH">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：<span title="${user.address}">${user.address}</span>
										</li>

										<li class="addH">客&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户：<span title="${user.name}">${user.name}</span>
										</li>


									</div>
								</div>
							</div>
							<div class="smart-widget-footer">
								<button class="btn-lg btn-block btn_gh" type="button" onclick="contDetails('${user.ID}')">详细</button>
								<button type="button" class="btn btn-primary btn-lg btn-block" onclick="modifiDetails('${user.ID}')">修改</button>
							</div>
							<!-- ./smart-widget-footer -->
						</div>
						<!-- ./smart-widget-inner -->
					</div>
					<!-- ./smart-widget -->
				</div>
			</c:forEach>
		</div>
	
			<div class="foot-box">
				<div class="center-footer">
					<span>上一页</span>
					<span>下一页</span>
				</div>
			
			</div>

	</div>
	</header>

	<%@ include file="/bottom.jsp"%>
	

	<script type="text/javascript" src="../static/js/bootstrap-select.min.js"></script>
	<script type="text/javascript" src="../static/js/customerActive/contactsList.js"></script>
</body>
</html>