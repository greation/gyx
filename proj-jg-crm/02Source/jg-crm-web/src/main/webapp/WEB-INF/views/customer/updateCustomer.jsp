<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<%@ include file="/top.jsp"%>
	
	<c:choose>
		<c:when test="${pageType=='update'}"><form action="custUpdate" id="saveForm" method="post" enctype="multipart/form-data"></c:when>  
		<c:otherwise><form action="custAdd" id="saveForm" method="post" enctype="multipart/form-data"></c:otherwise> 
	</c:choose>
	
		<!-- Header -->
		<header>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="crm_panel">
							<span style="margin-right: 10px;">
								<img src="./../static/img/index/h-02.png" />
							</span>
							<span class="addC">
								<c:choose>
								   <c:when test="${pageType=='update'}">修改客户</c:when>  
								   <c:otherwise>创建客户 </c:otherwise> 
								</c:choose>
							</span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="smart-widget">
							<div class="smart-widget-header">
								<span>客户信息 </span>
								<!-- <span class="fileInputContainer">
								    <input class="fileInput" type="file" name="" id="" />
								</span> -->
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
										<input type="hidden" name="custID" value="${custBean.custId}" />
										<input type="hidden" name="contID" value="${custBean.contID}" />
										<input type="hidden" name="compID" value="${custBean.compID}" />
										<input type="hidden" id="oldCustBeanName" value="${custBean.name}" />
											<input type="text" value="${custBean.name}" id="_custName" name="name"
												class="form-control">
										</div>
									</div>
									<%-- <div class="form-group">
										<label class="col-sm-3 control-label">注册资金</label>
										<div class="col-sm-9">
											<input type="text" id="_capital" name="capital" class="form-control" value="${custBean.capital}">
										</div>
									</div> --%>
									<div class="form-group">
										<label class="col-sm-3 control-label">联系人</label>
										<div class="col-sm-9">
											<input type="text" id="_conname" name="conname" value="${custBean.conname}" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label" style="width: 26%">其他联系方式</label>
										<div class="col-sm-9" style="width: 74%">
											<input type="text" id="_faxes" name="faxes" value="${custBean.faxes}"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">客户级别</label>
										<div class="col-sm-9">
											<select id="classification" id="_level" name="level" class="selectpicker">
												<option value="1" <c:if  test="${custBean.level == 1}"> selected="selected"</c:if>>A类</option>
												<option value="2" <c:if  test="${custBean.level == 2}"> selected="selected"</c:if>>B类</option>
												<option value="3" <c:if  test="${custBean.level == 3}"> selected="selected"</c:if>>C类</option>
											</select>
										</div>
									</div>
								<%-- 	<div class="form-group">
										<label class="col-sm-3 control-label">公司性质</label>
										<div class="col-sm-9">
											<select id="_corpKind" class="selectpicker" name="corpKind" data-hide-disabled="true" data-live-search="true">
												<optgroup>
													<option value="0">公司性质</option>
													<c:forEach items="${corpKindList}" var="clist">
														<option value="${clist.code }"  <c:if  test="${clist.code == custBean.corpKind}"> selected="selected"</c:if>>${clist.caption}</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div> --%>
									<div class="form-group">
										<label class="col-sm-3 control-label">所在行业</label>
										<div class="col-sm-9">
											<select id="_industry" class="selectpicker" name="industry" data-hide-disabled="true" data-live-search="true">
												<optgroup>
													<option value="0">所在行业</option>
													<c:forEach items="${industryList}" var="inlist">
														<option value="${inlist.code }" <c:if  test="${inlist.code == custBean.industry}"> selected="selected"</c:if>>${inlist.caption}</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="form-group">
										
									</div>
								</div>
								<div class="form-horizontal m-top-md" style="float: right; width: 50%;">
									<%-- <div class="form-group">
										 <label class="col-sm-3 control-label">法人</label>
										<div class="col-sm-9">
											<input type="text" id="_legal" name="legal" value="${custBean.legal}"
												class="form-control">
										</div>
									</div>   --%>
									<div class="form-group">
										<label class="col-sm-3 control-label">所在地区</label>
										<div class="col-sm-9">
											<select id="local-area3" name="region" class="selectpicker" data-hide-disabled="true" data-live-search="true">
												<optgroup>
													<option value="0">所在地区</option>
													<c:forEach items="${regionList}" var="clist">
														<option value="${clist.code }"  <c:if  test="${clist.code == custBean.region}"> selected="selected"</c:if>>${clist.caption}</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">联系电话</label>
										<div class="col-sm-9">
											<input type="text" id="checkphone" name="telphone" value="${custBean.telphone}"
												class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">客户状态</label>
										<div class="col-sm-9">
											<select id="classification" id="_classification"
												name="classification" class="selectpicker">
												<option value="1" <c:if  test="${custBean.classification == 1}"> selected="selected"</c:if>>已成交</option>
												<option value="2" <c:if  test="${custBean.classification == 2}"> selected="selected"</c:if>>未成交</option>
											</select>
										</div>
									</div>
									
									<div class="form-group">
	
										<label class="col-sm-3 control-label">客户类型</label>
										<div class="col-sm-9">
											<select id="classification" id="_custType" name="custType"
												class="selectpicker">
												
												<option value="0" <c:if  test="${custBean.custType == 0}"> selected="selected"</c:if>>采购商</option>
												<option value="1" <c:if  test="${custBean.custType == 1}"> selected="selected"</c:if>>供应商</option>
											</select>
										</div>
									</div>
									
									<div class="form-group" style="visibility: hidden;">
										<label class="col-sm-3 control-label">称呼 </label>
										<div class="col-sm-9">
											<input type="text" id="title" name="title" value="${custBean.title }"
												class="form-control">
										</div>
								<%-- 	<div class="form-group">
										<label class="col-sm-3 control-label">所属用户</label>
										<div class="col-sm-9">
											<select id="nature-of-company" class="selectpicker" name="owner" data-hide-disabled="true" data-live-search="true">
												<optgroup>
													<option value="${user.GID }">${user.name}</option>
													<option value="">无</option>
												</optgroup>
											</select>
										</div>
									</div> --%>
									<div class="form-group">
										
									</div>
									<div class="form-group">
										
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
								
								
							<c:if test="${addList==null}">
									<div class="form-horizontal m-top-md">
											<div class="form-group">
												<label class="control-label" style="float: left;">详细地址</label>
												<input type="hidden" name="addressList[0].ID" value="" />
												<input type="hidden" name="addressList[0].name" value="详细地址" />
												<div class="col-sm-10">
													<input type="text" class="form-control" name="addressList[0].address" value="">
												</div>
											</div>
										</div>
								 </c:if> 
								
								<c:forEach items="${addList}" var="alist" varStatus="status">
									<div class="form-horizontal m-top-md">
										<div class="form-group">
											<label class="control-label" style="float: left;">详细地址</label>
											<input type="hidden" name="addressList[${status.index}].ID" value="${alist.ID}" />
											<input type="hidden" name="addressList[${status.index}].name" value="${alist.name}" />
											<div class="col-sm-10">
												<input type="text" class="form-control" name="addressList[${status.index}].address" value="${alist.address}">
											</div>
											
										</div>
									</div>
									
								</c:forEach> 
									
								</div>
								<!-- <button onclick="addAddress()" class="btn btn-default addcus2"
									type="button">
									<span style="color: #0074C1;">+</span>添加地址
								</button> -->
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
											<textarea rows="3" class="form-control" id="_desc" name="description">${custBean.description}</textarea>
										</div>
										<!-- /.col -->
									</div>
								</div>
							</div>
							<!-- ./smart-widget-inner -->
						</div>
						<div class="smart-widget-footer">
							<button type="button" onclick="savaCustomer()" class="btn-lg btn-block btn_gh">保存</button>
							
							
							<c:choose>
			<c:when test="${pageType=='update'}"></c:when>  
			<c:otherwise><button class="btn btn-primary btn-lg btn-block" onclick="savaAndCreateCustomer()" type="button">保存并新建</button></c:otherwise> 
		</c:choose>
							<!-- <button class="btn btn-primary btn-lg btn-block" onclick="savaAndCreateCustomer()" type="button">保存并新建</button> -->
							<button class="btn btn-cancel btn-lg btn-block" onclick="javascript:history.go(-1)" type="button">取消</button>
						</div>
					</div>
				</div>
			</div>
		</header>
	</form>
	<%@ include file="/bottom.jsp"%>

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