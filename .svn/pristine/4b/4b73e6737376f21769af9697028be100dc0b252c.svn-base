<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="${pageContext.request.contextPath}/jsp/resource/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<link
	href="${pageContext.request.contextPath}/jsp/resource/bootstrap-4.3.1-dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>

<body>
	<div id="wrapper">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/return">Cars Rent</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<c:choose>
					<c:when test="${sessionScope.role == 'admin'}">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/carListAdmin"><f:message
										key="admin.carlist" /></a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/managerList"> <f:message
										key="admin.managersList" /></a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/userList"><f:message
										key="admin.usersList" /></a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/jsp/admin/regManager.jsp"><f:message
										key="admin.button.regManager" /></a></li>


						</ul>
					</c:when>

					<c:when test="${sessionScope.role == 'manager'}">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/newOrders"><f:message
										key="manager.newOrders" /></a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/orderListManager"><f:message
										key="manager.orderList" /></a></li>
						</ul>
					</c:when>

					<c:otherwise>
						<ul class="navbar-nav mr-auto">
							<li
								class="nav-item ${pageContext.request.requestURL == (pageContext.request.contextPath) ? 'active' : ''}"><a
								class="nav-link"
								href="${pageContext.request.contextPath}/carList"> <f:message
										key="admin.carlist" /></a></li>
							<c:if test="${not empty sessionScope.role}">
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath}/userOrders"><f:message
											key="user.myOrders" /></a></li>
							</c:if>


						</ul>
					</c:otherwise>
				</c:choose>

				<form class="form-inline">
					<select id="language" class="form-control" name="language"
						onchange="submit()">
						<option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
						<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
					</select>
				</form>
				<c:choose>
					<c:when test="${empty sessionScope.role}">
						<form class="form-inline my-2 my-lg-0" method="post"
							action="${pageContext.request.contextPath}/login">
							<c:choose>
								<c:when test="${language=='ru_RU'}">
									<input name="locale" value="ru" hidden />
								</c:when>
								<c:otherwise>
									<input name="locale" value="${language}" hidden />
								</c:otherwise>
							</c:choose>
							<input class="form-control ml-2"
								placeholder="<f:message key="enter.email"/>" type="email"
								name="email" required=""> <input
								class="form-control ml-2"
								placeholder="<f:message key="enter.password"/>" type="password"
								required="" name="password">

							<button type="submit" class="btn btn-outline-primary ml-2">
								<f:message key="button.signin" />
							</button>
							<a class="btn btn-outline-warning ml-2"
								href="${pageContext.request.contextPath}/jsp/authentication/registration.jsp">
								<f:message key="button.register" />
							</a>
						</form>
					</c:when>

					<c:otherwise>
						<a href="${pageContext.request.contextPath}/logout"
							class="btn btn-danger ml-2" title="Logout"><i
							class="btn-danger"><f:message key="button.logout" /></i></a>
					</c:otherwise>
				</c:choose>
			</div>
		</nav>

		<div id="content" class="p-2"	>