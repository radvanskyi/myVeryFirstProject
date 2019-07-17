<%@include file="/jsp/taglibs.jsp"%>

<html>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.role}">
			<div class="col-lg-4">
				<form class="form-group">
					<select id="language" class="form-control" name="language"
						onchange="submit()">
						<option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
						<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
					</select>
				</form>
			</div>
			<div class="col-lg-8">
				<form class="form-inline" method="post"
					action="${pageContext.request.contextPath}/login">
					<c:choose>
						<c:when test="${language=='ru_RU'}">
							<input name="locale" value="ru" hidden />
						</c:when>
						<c:otherwise>
							<input name="locale" value="${language}" hidden />
						</c:otherwise>
					</c:choose>
					<input class="form-control"
						placeholder="<f:message key="enter.email"/>" type="text"
						name="email" required=""> <input class="form-control"
						placeholder="<fmt:message key="enter.password"/>" type="password"
						required="" name="password">

					<button type="submit" class="btn btn-primary">
						<f:message key="button.signin" />
					</button>
				</form>
				<div>
					<a
						href="${pageContext.request.contextPath}/jsp/authentication/registration.jsp">
						<button class="btn btn-warning">
							<f:message key="button.register" />
						</button>
					</a>
				</div>
			</div>
		</c:when>

		<c:otherwise>
			<a href="${pageContext.request.contextPath}/logout"
				class="btn btn-danger" title="Logout"><i class="btn-danger"><f:message
						key="button.logout" /></i></a>
		</c:otherwise>
	</c:choose>

	<div class="container col-lg-12">
		<c:forEach var="check" items="${checks}">
			<div class="panel panel-success">
				<div class="panel-body">
					<div class="col-lg-6">
						<p class="h4">
							<f:message key="order" />
						</p>
						<c:forEach var="order" items="${check.orders}">
							<div class="panel-body">
								<c:set var="status" value="${order.status.name}" />
								<div class="col-lg-6">
									<f:message key="car.mark" />
									: ${order.car.mark}<br />
									<f:message key="car.model" />
									: ${order.car.model}<br />
									<f:message key="car.carClass" />
									: ${order.car.carClass.name}<br />
									<f:message key="car.costPerDay" />
									: ${order.car.price}<br />
								</div>
								<div class="col-lg-6">
									<f:message key="user" />
									<f:message key="order.passport" />
									: ${order.passport}<br />
									<f:message key="order.startDate" />
									: ${order.startDate}<br />
									<f:message key="order.endDate" />
									: ${order.endDate}<br />
									<f:message key="order.driver" />
									: ${order.driver}<br />
									<f:message key="order" />
									<f:message key="global.status" />
									: ${order.status.name}<br />
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="col-lg-6">
						<p class="h4">
							<f:message key="check" />
							: ${check.id}
						</p>
						<br />
						<f:message key="order.currentDate" />
						: ${check.date}<br />
						<f:message key="check.description" />
						: ${check.description}<br />
						<f:message key="global.status" />
						: ${check.status.name}<br />

						<div class="h3">
							<f:message key="check.totalCost" />
							: ${check.price}
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
