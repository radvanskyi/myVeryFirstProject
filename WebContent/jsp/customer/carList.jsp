<%@include file="/jsp/taglibs.jsp"%>

<c:if test="${marks != null}">
	<div class="container-fluid">
		<div class="row border-bottom">
			<div class="col-md-3 py-2 px-2">
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

			<div class="col-md-3 py-2 px-2">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					<f:message key="car.setCarClass" />
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<c:forEach var="carClass" items="${classes}">
						<li><a class="dropdown-item"
							href="${pageContext.request.contextPath}/carSort?carClass=${carClass.name}">${carClass.name}</a>
						</li>
					</c:forEach>
				</ul>
			</div>

			<div class="col-md-3 py-2 px-2">
				<a href="${pageContext.request.contextPath}/carSort?price=true">
					<button class="btn btn-primary">
						<f:message key="user.sortByPrice" />
					</button>
				</a>
			</div>

			<div class="col-md-3 py-2 px-2">
				<a href="${pageContext.request.contextPath}/carSort?model=true">
					<button class="btn btn-primary">
						<f:message key="user.sortByModel" />
					</button>
				</a>
			</div>
		</div>
	</div>
</c:if>

<div id="page-inner" class="row p-1">
	<c:forEach var="car" items="${cars}">

		<div class="col-md-3 p-3">
			<div class="card">
				<form action="${pageContext.request.contextPath}/orderCar"
					method="post">
					<div class="card-body">
						<input name="id" value="${car.id}" hidden />
						<p>
							<f:message key="car.mark" />
							: ${car.mark}
						</p>
						<p>
							<f:message key="car.model" />
							: ${car.model}
						</p>
						<p>
							<f:message key="car.costPerDay" />
							: ${car.price}
						</p>
						<p>
							<f:message key="car.carClass" />
							: ${car.carClass.name}
						</p>
						<p>
							<f:message key="global.status" />
							: ${car.status.name}
						</p>
					</div>
					<div class="card-footer">
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
				</form>
			</div>
		</div>

	</c:forEach>
</div>

<%@ include file="/jsp/foot.jsp"%>