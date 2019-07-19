<%@include file="/jsp/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Cars List</title>
</head>
<body>
	<div class="col-sm-4">
		<form class="form-group">
			<select id="language" class="form-control" name="language"
				onchange="submit()">
				<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
				<option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
			</select>
		</form>
	</div>
	<br>
	<a href="${pageContext.request.contextPath}/return">
		<button class="btn btn-primary">
			<f:message key="manager.button.return" />
		</button>
	</a>

	<div id="page-wrapper">
		<%@ include file="/jsp/customer/filters.jsp"%>
		<div id="page-inner">
			<c:forEach var="car" items="${cars}">
				<form action="${pageContext.request.contextPath}/orderCar"
					method="post">
					<div class="panel panel-primary">
						<div class="row panel-body">
							<div class="col-md-12">
								<input name="id" value="${car.id}" hidden />
								<div class="col-md-2">
									<f:message key="car.mark" />
									: ${car.mark}
								</div>
								<div class="col-md-2">
									<f:message key="car.model" />
									: ${car.model}
								</div>
								<div class="col-md-2">
									<f:message key="car.costPerDay" />
									: ${car.price}
								</div>
								<div class="col-md-2">
									<f:message key="car.carClass" />
									: ${car.carClass.name}
								</div>
								<div class="col-md-2">
									<f:message key="global.status" />
									: ${car.status.name}
								</div>
								<div class="col-md-2">
									<c:choose>
										<c:when test="${car.status.name=='disable'}">
											<a
												href="${pageContext.request.contextPath}/orderCar?id=${car.id}">
												<input name="id" value="${car.id}" hidden>
												<button name="rent" class="btn btn-danger" disabled>
													<f:message key="user.busy" />
												</button>
											</a>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${not empty sessionScope.role}">
													<a
														href="${pageContext.request.contextPath}/orderCar?id=${car.id}">
														<input name="id" value="${car.id}" hidden>
														<button name="rent" class="btn btn-warning">
															<f:message key="user.rent" />
														</button>
													</a>
												</c:when>
												<c:otherwise>
													<button name="rent" class="btn btn-warning"
														title="<f:message key="pleaseSignIn"/>" disabled>
														<f:message key="user.rent" />
													</button>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
	</div>
</body>
</html>