<%@include file="/jsp/taglibs.jsp"%>

<div class="container col-lg-12">
	<c:forEach var="check" items="${checks}">
		<div class="panel panel-primary">
			<div class="panel-body">
				<div class="col-lg-6">
					<p class="h4">
						<f:message key="order" />
					</p>
					<c:forEach var="order" items="${check.orders}">
						<div class="panel-body">
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

<%@include file="/jsp/foot.jsp"%>