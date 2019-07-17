<%@include file="/jsp/taglibs.jsp"%>

<html>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
			<div class="header-right">
				<a href="${pageContext.request.contextPath}/logout"
					class="btn btn-danger" title="Logout"><i class="btn-danger"><f:message
							key="button.logout" /></i></a>
			</div>
		</nav>
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li>
						<div class="user-img-div">
							<div class="inner-text">
								<p>${email}</p>
							</div>
						</div>
					</li>

					<li><a href="${pageContext.request.contextPath}/newOrders"><i
							class="fa"></i> <f:message key="manager.newOrders" /></a></li>
					<li><a
						href="${pageContext.request.contextPath}/orderListManager"><i
							class="fa"></i> <f:message key="manager.orderList" /></a></li>
				</ul>
			</div>

		</nav>
		<div id="page-wrapper">
			<div id="page-inner">


				<%@include file="/jsp/manager/newOrders.jsp"%>

				<%@include file="/jsp/manager/orderList.jsp"%>

			</div>
		</div>
	</div>
</body>
</html>
