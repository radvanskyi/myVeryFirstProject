<%@include file="/jsp/taglibs.jsp"%>

<a href="${pageContext.request.contextPath}/return">
	<button class="btn btn-primary">
		<f:message key="manager.button.return" />
	</button>
</a>
<br>

<div class="container col-lg-12">
	<div class="panel-heading">
		<p>
			<f:message key="heading.ordersForConfrim" />
		</p>
	</div>
	<c:forEach var="check" items="${unpaid}">
		<div class="panel panel-primary">
			<div class="panel-body">
				<c:forEach var="order" items="${check.orders}">
					<c:set var="Norder" value="${order}" />
					<div class="panel-body">
						<div class="col-lg-4">
							<f:message key="car.mark" />
							: ${order.car.mark}<br />
							<f:message key="car.model" />
							: ${order.car.model}<br />
							<f:message key="car.carClass" />
							: ${order.car.carClass.name}<br />
							<f:message key="car.costPerDay" />
							: ${order.car.price}<br />
						</div>
						<div class="col-lg-5">
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
				<div class="col-lg-3">
					<p class="h3">
						<f:message key="user" />
					</p>

					<f:message key="user.email" />
					: ${Norder.user.email}<br />
					<f:message key="user.password" />
					: ${Norder.user.password}<br />
					<f:message key="user.firstName" />
					: ${Norder.user.firstName}<br />
					<f:message key="user.lastName" />
					: ${Norder.user.lastName}<br />
				</div>

				<form class="form-group"
					action="${pageContext.request.contextPath}/cancelOrder"
					method="post">
					<div class="col-lg-3">
						<p class="h3">
							<f:message key="check" />
							: ${check.id} <input type="number" name="id" value="${check.id}"
								hidden />
						</p>
						<div class="h3">
							<f:message key="check.totalCost" />
							: ${check.price}<br />
						</div>
						<label for="desc"><f:message key="check.description" />:
							${check.description}</label><br /> <br />
					</div>
					<button type="submit" class="btn btn-danger">
						<f:message key="manager.button.cancel" />
					</button>
				</form>
				<form action="${pageContext.request.contextPath}/confirmOrder">
					<input name="id" value="${check.id}" hidden>
					<button type="submit" class="btn btn-success">
						<f:message key="manager.button.confirm" />
					</button>
				</form>
			</div>
		</div>
	</c:forEach>

	<c:forEach var="check" items="${returned}">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<f:message key="heading.returnedCar" />
			</div>
			<div class="panel-body">
				<c:forEach var="order" items="${check.orders}">
					<div class="panel-body">
						<c:set var="status" value="${order.status.name}" />
						<c:set var="Norder" value="${order}" />
						<div class="col-lg-3">
							<f:message key="car.mark" />
							: ${order.car.mark}<br />
							<f:message key="car.model" />
							: ${order.car.model}<br />
						</div>
						<div class="col-lg-3">
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
						<div class="col-lg-3">
							<c:if test="${order.status.name=='returned'}">
								<a
									href="${pageContext.request.contextPath}/createRepairPage?id=${order.id}">
									<button class="btn btn-warning">
										<f:message key="manager.button.repair" />
									</button>
								</a>
							</c:if>
						</div>
					</div>
				</c:forEach>
				<br />
				<div class="col-lg-3">
					<f:message key="user" />
					: ${Norder.user.firstName} ${Norder.user.lastName}
					<br/>
					<f:message key="user.email" />
					: ${Norder.user.email}
					<br/>
					<f:message key="check" />
					<f:message key="check.description" />
					: ${check.description}
					<br/>
					<f:message key="check.totalCost" />
					: ${check.price}
					<br/>
					<form action="${pageContext.request.contextPath}/finishOrder"
						method="post">
						<input name="id" value="${check.id}" hidden>
						<button type="submit" class="btn btn-primary">
							<f:message key="manager.button.accept" />
						</button>
					</form>
				</div>
			</div>
		</div>
	</c:forEach>
</div>