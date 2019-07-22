<%@include file="/jsp/taglibs.jsp"%>

<div class="row">
	<c:forEach var="order" items="${orders}">
		<div class="cold-md-3">
			<div class="card">
				<div class="card-body">
					<p class="h4">
							<f:message key="order" />
						</p>
						
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
						<p class="h4">
							<f:message key="check" />
							: ${order.getCheck().id}
						</p>
						<br />
						<f:message key="order.currentDate" />
						: ${order.getCheck().date}<br />
						<f:message key="check.description" />
						: ${order.getCheck().description}<br />
						<f:message key="global.status" />
						: ${order.getCheck().status.name}<br />
					</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@include file="/jsp/foot.jsp"%>