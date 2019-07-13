<%@include file="/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Cars List</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/orderCar"
		method="post">
		<c:forEach var="car" items="${list}">
			<div class="panel panel-primary">
				<div class="row panel-body">
					<div class="col-md-12">
						<div class="col-md-2">
							<p>
								<f:message key="car.mark" />
								: ${car.mark}
							</p>
						</div>
						<div class="col-md-2">
							<p>
								<f:message key="car.model" />
								: ${car.model}
							</p>
						</div>
						<div class="col-md-2">
							<p>
								<f:message key="car.costPerDay" />
								: ${car.price}
							</p>
						</div>
						<div class="col-md-2">
							<p>
								<f:message key="car.carClass" />
								: ${car.carClass.name}
							</p>
						</div>
						<div class="col-md-2">
							<p>
								<f:message key="global.status" />
								: ${car.status.name}
							</p>
						</div>
						<div class="col-md-2">
							<c:choose>
								<c:when test="${car.status.name=='disable'}">
									<a
										href="${pageContext.request.contextPath}/orderPage?id=${car.id}">
										<button name="rent" class="btn btn-danger" disabled>
											<f:message key="user.busy" />
										</button>
									</a>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${not empty sessionScope.role}">
											<a
												href="${pageContext.request.contextPath}/orderPage?id=${car.id}">
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
		</c:forEach>
	</form>
</body>
</html>