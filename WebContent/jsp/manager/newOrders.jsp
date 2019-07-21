<%@include file="/jsp/taglibs.jsp"%>

<div class="row border-bottom p-2 b-2">
	<h3>
		<f:message key="heading.ordersForConfrim" />
	</h3>
</div>
<div class="row">
	<c:forEach var="check" items="${unpaid}">
		<div class="col-md-3">
			<div class="card">
				<div class="card-body">
					<c:forEach var="order" items="${check.orders}">
						<div class="row border-bottom mb-2">
							<c:set var="Norder" value="${order}" />
							<f:message key="car.mark" />
							: ${order.car.mark}<br />
							<f:message key="car.model" />
							: ${order.car.model}<br />
							<f:message key="car.carClass" />
							: ${order.car.carClass.name}<br />
							<f:message key="car.costPerDay" />
							: ${order.car.price}<br />

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
					</c:forEach>
					<div class="border-bottom">
						<h3>
							<f:message key="user" />
						</h3>


						<p>
							<f:message key="user.email" />
							: ${Norder.user.email}
						</p>
						<p>
							<f:message key="user.password" />
							: ${Norder.user.password}
						</p>
						<p>
							<f:message key="user.firstName" />
							: ${Norder.user.firstName}
						</p>
						<p>
							<f:message key="user.lastName" />
							: ${Norder.user.lastName}
						</p>
					</div>
					<div class="border-bottom">
						<form class="inline"
							action="${pageContext.request.contextPath}/cancelOrder"
							method="post">
							<p class="h3">
								<f:message key="check" />
								: ${check.id} <input type="number" name="id" value="${check.id}"
									hidden />
							</p>
							<div class="h3">
								<f:message key="check.totalCost" />
								: ${check.price}
							</div>
							<label for="desc"><f:message key="check.description" />:
								${check.description}</label>
							<button type="submit" class="btn btn-danger">
								<f:message key="manager.button.cancel" />
							</button>
						</form>
						<form class="mt-2"
							action="${pageContext.request.contextPath}/confirmOrder">
							<input name="id" value="${check.id}" hidden>
							<button type="submit" class="btn btn-success">
								<f:message key="manager.button.confirm" />
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<div class="row border-bottom border-top p-2 b-2">
	<h3>
		<f:message key="heading.returnedCar" />
	</h3>
</div>
<div class="row">
	<c:forEach var="order" items="${returned}">
		<div class="col-md-3">
			<div class="card">
				<div class="card-body">
						<f:message key="car.mark" />
							: ${order.car.mark}<br />
							<f:message key="car.model" />
							: ${order.car.model}<br />
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
						<div class="card-footer">
							<a
									href="${pageContext.request.contextPath}/createRepairPage?id=${order.id}">
									<button class="btn btn-warning">
										<f:message key="manager.button.repair" />
									</button>
								</a>
								
								<a
									href="${pageContext.request.contextPath}/finishOrder?id=${order.id}">
									<button class="btn btn-warning">
										<f:message key="manager.button.accept" />
									</button>
								</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<%@include file="/jsp/foot.jsp"%>