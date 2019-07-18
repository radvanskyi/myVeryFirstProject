<%@include file="/jsp/taglibs.jsp"%>

<html>
<body>
	<div>
		<a href="${pageContext.request.contextPath}/return">
			<button class="btn btn-danger">
				<f:message key="manager.button.return" />
			</button>
		</a>
	</div>

	<div class="panel panel-primary col-lg-offset-2 col-lg-8">
		<div class="panel-heading">
			<p class="h3">
				<f:message key="heading.repairPage" />
			</p>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-6">
					<p class="h3">
						<f:message key="car" />
					</p>
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
					<p class="h3">
						<f:message key="user" />
					</p>

					<f:message key="user.email" />
					: ${order.user.email} <br />
					<f:message key="order.passport" />
					: ${order.passport}<br />
				</div>
			</div>
			<br/>
			<div class="row">
				<form class="form-group"
					action="${pageContext.request.contextPath}/repairOrder">
					<label for="check"><f:message key="check" /> <input
						type="number" name="id" value="${order.id}" id="check" hidden></label><br />

					<div class="col-lg-3">
						<label for="startDate"><f:message key="order.startDate" />: ${order.startDate}
						</label>
					</div>
					<div class="col-lg-3">
						<label for="finishDate"><f:message key="order.endDate" />: ${order.endDate} </label>
					</div>
					<label><f:message key="check.description" />: ${order.check.description}</label><br />
					<br /> <label for="price"><f:message key="car.price" />: </label> <input
						type="number" name="price" class="form-control" id="price" />
					<button class="btn btn-primary" type="submit">
						<f:message key="manager.button.createOrder" />
					</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
