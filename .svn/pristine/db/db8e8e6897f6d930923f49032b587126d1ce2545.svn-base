<%@include file="/jsp/taglibs.jsp"%>

<c:if test="${not empty waitList}">
	<div class="row border-bottom">
		<div class="col-md-8">
			<p class="h3 panel-heading">
				<f:message key="unfinshedOrders" />
			</p>
		</div>
		<div class="col-md-2">
			<form method="post"
				action="${pageContext.request.contextPath}/makeCheck">
				<button type="submit" class="btn btn-warning">
					<f:message key="makeCheck.button" />
				</button>
			</form>
		</div>
		<div class="col-md-2">
			<form action="${pageContext.request.contextPath}/deleteTempOrders"
				method="post">
				<button type="submit" class="btn btn-danger">
					<f:message key="admin.button.delete" />
				</button>
			</form>
		</div>
	</div>
	<div class="row">
		<c:forEach var="waitorder" items="${waitList}">
			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<div class="col-md-6">
							<f:message key="car.mark" />
							: ${waitorder.car.mark}<br />
							<f:message key="car.model" />
							: ${waitorder.car.model}<br />
							<f:message key="car.carClass" />
							: ${waitorder.car.carClass.name}<br />
							<f:message key="car.costPerDay" />
							: ${waitorder.car.price}<br />
						</div>
						<div class="col-md-6">
							<f:message key="user" />
							<f:message key="order.passport" />
							: ${waitorder.passport}<br />
							<f:message key="order.startDate" />
							: ${waitorder.startDate}<br />
							<f:message key="order.endDate" />
							: ${waitorder.endDate}<br />
							<f:message key="order.driver" />
							: ${waitorder.driver}<br />
							<f:message key="order" />
							<f:message key="global.status" />
							: ${waitorder.status.name}<br />
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</c:if>

<c:if test="${not empty checkList}">
	<div class="row border-bottom">
		<div class="col-md-8">
			<p class="h3 panel-heading">
				<f:message key="listOfOrders" />
			</p>
		</div>
	</div>
	<div class="row">
		<c:forEach var="check" items="${checkList}">
			<div class="col-md-3">
				<div class="card">

					<div class="card-header">
						<p class="h4">
							<f:message key="order" /> # ${check.id}
						</p>
					</div>
					<div class="card-body">
						<c:forEach var="order" items="${check.orders}">
							<div class="row">
								<c:set var="status" value="${order.status.name}" />
								<div class="col-md-6">
									<f:message key="car.mark" />
									: ${order.car.mark}<br />
									<f:message key="car.model" />
									: ${order.car.model}<br />
									<f:message key="car.carClass" />
									: ${order.car.carClass.name}<br />
									<f:message key="car.costPerDay" />
									: ${order.car.price}<br />
								</div>
								<div class="col-md-6">
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
					<div class="col-md-6">
						<p class="h4">
							<f:message key="check" />
							: ${check.id}
						</p>
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
					<div class="card-footer">
					<c:choose>
						<c:when test="${check.status.name=='accepted'}">
							<c:choose>
								<c:when test="${status=='rent'}">
									<form action="${pageContext.request.contextPath}/payOrder"
										method="post">
										<input name="id" value="${check.id}" hidden> <input
											name="rent" value="true" hidden>
										<button type="submit" class="btn btn-success">
											<f:message key="user.button.payRent" />
										</button>
									</form>
								</c:when>
								<c:when test="${status=='repair'}">
									<form method="post"
										action="${pageContext.request.contextPath}/payOrder">
										<input name="id" value="${check.id}" hidden> <input
											name="repair" value="true" hidden>
										<button type="submit" class="btn btn-success">
											<f:message key="user.button.payRepair" />
										</button>
									</form>
								</c:when>
							</c:choose>
						</c:when>
						<c:when test="${check.status.name=='canceled'}">
							
								<p class="h2" style="color: red">
									<f:message key="user.info.orderCanceled" />
								</p>
							

						</c:when>
						<c:when test="${check.status.name=='paid'}">
							<c:choose>
								<c:when test="${status=='rent'}">
									<form action="${pageContext.request.contextPath}/returnCar"
										method="post">
										<input name="id" value="${check.id}" hidden>
										<button type="submit" class="btn btn-warning">
											<f:message key="user.button.returnCar" />
										</button>
									</form>
								</c:when>
								<c:when test="${status=='returned'}">
									<p class="h2 bg-info">
										<f:message key="user.info.carBroken" />
									</p>
								</c:when>
							</c:choose>
						</c:when>
					</c:choose>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</c:if>
<%@include file="/jsp/foot.jsp"%>

