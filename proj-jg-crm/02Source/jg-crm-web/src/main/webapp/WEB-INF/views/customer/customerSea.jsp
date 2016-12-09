<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<link href="../static/css/agency.css" rel="stylesheet">
		<link rel="stylesheet" href="../static/css/customer/customerSea.css" />
		
		<body id="page-top" class="index">

			<!-- Navigation -->
		  <%@ include file="/top.jsp"%>

			<!-- Header -->
			<header>
				<div class="container">

					<div class="row">
						<div class="col-md-12">
							<div class="crm_panel">
								<span style="margin-right: 10px;">
									<img src="../static/img/index/08.png"/>
								</span>
								<span class="fs_24">客户海</span>
								<span class="fs_18" style="margin-left: 10px; font-weight: normal;">(总量${ccount })</span>
								
								<a href="jumpAddcustomer" type="button" class="btn btn-default addcus2">
									<span class="addS">+</span>
									<span class="customerS" >添加客户</span>
								</a>
								
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="col-lg-8" style="margin-left:25%">
								<div class="smart-widget widget-purple">
									<div class="smart-widget-header" style="background-color:#fdaa29 ; font-weight:bold; font-size: 24px">
										公&nbsp;海
									</div>
									<div class="smart-widget-inner">
										<div class="smart-widget-body">
											<div class="">
												<div class="list_style sea_header fs_16">
													<div>当前客户数量：<span><a href="../Cust/findCustomerInfo.do"  class="fs_18">${publicCount }</a></span></div>
													<div>新增客户数量：<span><a href="../Cust/findCustomerInfo.do?time=2016-05-06" class="fs_18">${newPublicCount }</a></span></div>
												</div>
												<div class="dashed_div"></div>
												<ul class="list_style sea_header">
													<li>过往公海客户变化情况</li>
												</ul>
												<div class="heightS">
												<c:forEach items="${publicSeaTraces}" var="pubSeaTraces" varStatus="vs">
													<ul>
														<li>
													<fmt:formatDate value="${pubSeaTraces.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>   
															<div class="StyH">${pubSeaTraces.name }
													<c:choose>	
													 <c:when test="${pubSeaTraces.action ==0}">插入</c:when>  
												   <c:when test="${pubSeaTraces.action ==1}">更新</c:when>  
												   <c:otherwise>删除</c:otherwise> 
													</c:choose> 
													${pubSeaTraces.customerName}
												</div>
														</li>
													</ul>
												 </c:forEach>
											</div>
											</div>
										</div>
										<div class="smart-widget-footer">
											<a href="../Cust/findCustomerInfo.do" type="button" class="btn btn-primary btn-lg btn-block">
												进入
											</a>
										</div>
										<!-- ./smart-widget-footer -->
									</div>
									<!-- ./smart-widget-inner -->
								</div>
							</div>
							<!-- ./smart-widget -->
						</div>
						<div class="col-lg-6">
							<div class="col-lg-8" style="margin-left:25%">
								<div class="smart-widget widget-purple">
									<div class="smart-widget-header" style="background-color:#56a8e7 ; font-weight:bold; font-size: 24px">
										私&nbsp;海
									</div>
									<div class="smart-widget-inner">
										<div class="smart-widget-body">
											<div>
											
												<div class="list_style sea_header fs_16">
													<div>当前客户数量：<span><a href="../Cust/findCustomerInfo.do?userid=11" class="fs_18">${privateCustomerCount }</a></span></div>
													<div>新增客户数量：<span><a href="../Cust/findCustomerInfo.do?userid=11&time=2016-05-06" class="fs_18">${newPrivateCount }</a></span></div>
												</div>
												<div class="dashed_div"></div>
												<ul class="list_style sea_header">
													<li>私海客户变化情况</li>
												</ul>
												 <div class="heightS">
													<c:forEach items="${privateSeaTraces}" var="priSeaTraces" varStatus="vS">
													<ul>
												
														<li class="StyH">
															<fmt:formatDate value="${priSeaTraces.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>   
														<div class="StyH">${pubSeaTraces.name }${priSeaTraces.name}
															<c:choose>	
														 <c:when test="${priSeaTraces.action ==0}">插入</c:when>  
													   <c:when test="${priSeaTraces.action ==1}">检入</c:when>  
													   <c:otherwise>检出</c:otherwise> 
														</c:choose>
														${priSeaTraces.customerName}
														</div>
															</li>
													</ul>
													</c:forEach>
												</div>												
											</div>
										</div>
										<div class="smart-widget-footer">
											<a href="../Cust/findCustomerInfo.do?seaType=1" type="button" class="btn btn-lg btn-block btn_gh">
												进入
											</a>
										</div>
										<!-- ./smart-widget-footer -->
									</div>
									<!-- ./smart-widget-inner -->
								</div>
							</div>
							<!-- ./smart-widget -->
						</div>
					</div>

				</div>
			</header>

		<%@ include file="/bottom.jsp"%>

		</body>

</html>