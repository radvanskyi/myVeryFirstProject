<%@include file="/jsp/taglibs.jsp"%>

<html>
<body>
	<div class="col-lg-4">
		<form class="form-group">
			<select id="language" class="form-control" name="language"
				onchange="submit()">
				<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
				<option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
			</select>
		</form>
	</div>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
			<div class="header-right">
				<a
					href="${pageContext.request.contextPath}/jsp/admin/regManager.jsp"><i
					class="btn btn-warning"><f:message
							key="admin.button.regManager" /></i></a> <a
					href="${pageContext.request.contextPath}/logout"
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
								<p>${username}</p>
							</div>
						</div>
					</li>

					<li><a href="${pageContext.request.contextPath}/carListAdmin"><i
							class="fa"></i>
						<f:message key="admin.carlist" /></a></li>
					<li><a href="${pageContext.request.contextPath}/managerList"><i
							class="fa"></i>
						<f:message key="admin.managersList" /></a></li>
					<li><a href="${pageContext.request.contextPath}/userList"><i
							class="fa"></i>
						<f:message key="admin.usersList" /></a></li>
				</ul>
			</div>

		</nav>
		
	</div>
</body>
</html>
