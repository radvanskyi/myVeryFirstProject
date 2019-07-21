<%@include file="/jsp/taglibs.jsp"%>

<div class="row border-bottom p-2 b-2">
	<h3>
		<f:message key="heading.repairPage" />
	</h3>
</div>
	<div class="card">
		<div class="card-body">
			<div class="col-md-3">
				<f:message key="car.mark" />
				: ${order.car.mark}<br />
				<f:message key="car.model" />
				: ${order.car.model}<br />
				<f:message key="car.carClass" />
				: ${order.car.carClass.name}<br />
				<f:message key="car.costPerDay" />
				: ${order.car.price}<br />
			</div>

			<div class="col-md-3">
				<h3 class="h3">
					<f:message key="user" />
				</h3>
				<f:message key="user.email" />
				: ${order.user.email} <br />
				<f:message key="order.passport" />
				: ${order.passport}<br />
			</div>

			<div class="col-md-3">
				<form class="form-group"
					action="${pageContext.request.contextPath}/repairOrder">
					<div>
					<label for="check"><f:message key="check" /> <input
						type="number" name="id" value="${order.id}" id="check" hidden></label>

						<label for="startDate"><f:message key="order.startDate" />:
							${order.startDate} </label>
						
						<label for="finishDate"><f:message key="order.endDate" />:
							${order.endDate} </label>
						
						<label><f:message key="check.description" />:
							${order.check.description}</label>
						
						<label for="price"><f:message key="car.price" />: </label> <input
							type="number" name="price" class="form-control" id="price" />
					</div>
					<div class="py-2">
					<button class="btn btn-primary" type="submit">
						<f:message key="manager.button.createOrder" />
					</button>
					</div>
				</form>
			</div>
		</div>
	</div>
<%@include file="/jsp/foot.jsp"%>