<%@include file="/jsp/taglibs.jsp"%>

<div id="page-wrapper">
	<c:if test="${marks != null}">
		<div class="container-fluid">
			<div class="row-inline">
				<div class="col-md-12">
					<div class="col-md-3">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								<f:message key="car.setMark" />
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<c:forEach var="mark" items="${marks}">
									<li><a class="dropdown-item"
										href="${pageContext.request.contextPath}/carSort?mark=${mark}">${mark}</a></li>
								</c:forEach>
							</ul>
						</div>

						<div class="col-md-3">
							<div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									data-toggle="dropdown">
									<f:message key="car.setCarClass" />
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<c:forEach var="carClass" items="${classes}">
										<li><a class="dropdown-item"
											href="${pageContext.request.contextPath}/carSort?carClass=${carClass}">${carClass}</a>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
						<div class="col-md-3">
							<a href="${pageContext.request.contextPath}/carSort?price=true">
								<button class="btn btn-primary">
									<f:message key="user.sortByPrice" />
								</button>
							</a>
						</div>
						<div class="col-md-3">
							<a href="${pageContext.request.contextPath}/carSort?model=true">
								<button class="btn btn-primary">
									<f:message key="user.sortByModel" />
								</button>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>

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

<%@ include file="/jsp/foot.jsp"%>