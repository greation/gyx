<%@ page import="com.jg2b.api.crm.login.pojo.UserPojo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

String loginUserName = "游客";
if(request.getSession().getAttribute("loginUser")!=null){
	UserPojo userBean = new UserPojo();
	userBean  = (UserPojo)request.getSession().getAttribute("loginUser");
	loginUserName = userBean.getName();
}
						
%>

<!-- jQuery -->
 <script src="<%=basePath%>/static/js/jquery-1.11.1.min.js"></script> 
<!-- Bootstrap Core JavaScript -->
<script src="<%=basePath%>/static/bootstrap/js/bootstrap.min.js"></script>

<script language="JavaScript">
	function userLogout() {
		$.ajax({
			type : "post",
			url : "<%=basePath%>/login/userLogout",
			dataType : "json",
			async : false,
			success : function(data) {
				window.location.href="<%=basePath%>/login.jsp";
			},
			error : function(msg) {
				alert("交互异常");
			}
		});
	}
</script>
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
				<a class="navbar-brand page-scroll" href="<%=basePath%>/index.jsp"><img
					class="img_style" src="<%=basePath%>/static/img/public/logo01.png"></a>
			</div>
	
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li><a class="page-scroll" href="#services">欢迎！<%=loginUserName %></a></li>
					<li><a class="page-scroll" href="#portfolio">信息（<span
							style="color: #ff0000;">0</span>）
					</a></li>
					<li>
					<%
								if(request.getSession().getAttribute("loginUser")!=null){
								%>
									<a class="page-scroll" href="###" onclick="userLogout()">退出</a>
								<%}else{%>
									<a class="page-scroll" href="<%=basePath%>/login.jsp">登录</a>
								<%}%>
						</li>
						
								
					<li><a class="page-scroll" href="<%=basePath%>/index.jsp">返回首页</a>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
</nav>