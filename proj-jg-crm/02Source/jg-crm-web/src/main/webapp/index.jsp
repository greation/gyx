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
		<link rel="stylesheet" href="static/css/index.css" />
		

		<body id="page-top" class="index">

			<!-- 引入头部页面 -->
			<%@ include file="top.jsp"%>
			<!-- Header -->
			<header>
				<div class="container">

					<div class="row">
						<div class="col-md-12">
							<div class="crm_panel">
								我的CRM面板
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 div_panel">
							<div class="statistic-box bg-danger1 m-bottom-md">
								
									<div class="statistic-value">
										<img src="static/img/index/04.png" />
									</div>
									<div class="m-top-md">线索</div>
								
							</div>
						</div>
						<div class="col-md-3 div_panel">
							<div class="statistic-box bg-danger2 m-bottom-md">
								<a href="Cust/findCustomerInfo">
								<div class="statistic-value">
									<img src="static/img/index/02.png" />
								</div>

								<div class="m-top-md">客户</div>
								</a>
							</div>
						</div>
						<div class="col-md-3 div_panel">
							<div class="statistic-box bg-danger3 m-bottom-md">
								<a href="Cust/findContactInfo">
								<div class="statistic-value">
									<img src="static/img/index/03.png" />
								</div>
								
								<div class="m-top-md">联系人</div>
								</a>
							</div>
						</div>
						<div class="col-md-3 div_panel">
							<div class="statistic-box bg-danger4 m-bottom-md">
								<a href="Cust/findActivities">
								<div class="statistic-value">
									<img src="static/img/index/01.png" />
								</div>

								<div class="m-top-md">拜访、通话及活动</div>
								</a>
							</div>
						</div>
						<div class="col-md-3 div_panel">
							<div class="statistic-box bg-danger5 m-bottom-md">

								<div class="statistic-value">
									<img src="static/img/index/05.png" />
								</div>

								<div class="m-top-md">报表</div>

							</div>
						</div>
						<div class="col-md-3 div_panel">
							<div class="statistic-box bg-danger6 m-bottom-md">

								<div class="statistic-value">
									<img src="static/img/index/06.png" />
								</div>

								<div class="m-top-md">用户管理</div>

							</div>
						</div>
					</div>

				</div>
			</header>
			
			<!-- 引入底部页面 -->
			<%@ include file="bottom.jsp"%>
			
			

		</body>

</html>
