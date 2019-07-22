<%@include file="/jsp/taglibs.jsp"%>

<div class="container-fluid">
	<div class="card">
		<div class="card-header">
			<h3>
				<f:message key="order.enterInfo" />
			</h3>
		</div>
		<form action="${pageContext.request.contextPath}/rentCar"
			method="post" class="form">
			<div class="card-body">
				<input name="id" value="${id}" hidden>
				<div class="row font-weight-bold">
					<div class="col-md-3">
						<p class="bold">
							<f:message key="car.mark" />
							: ${mark}
						</p>
					</div>
					<div class="col-md-3">
						<p>
							<f:message key="car.model" />
							: ${model}
						</p>
					</div>
					<div class="col-md-5">
						<p>
							<f:message key="car.costPerDay" />
							: ${price}
						</p>
					</div>
					<div class="col-md-1">
						<p>
							<f:message key="car.carClass" />
							: ${carClass}
						</p>
					</div>
				</div>
				<div class="row list inline">
					<div class="col-md-3">
						<label for="passport"><f:message key="order.passport" />:</label>
					</div>
					<div class="col-md-9">
						<input type="number" required="" name="passport"
							class="form-control" id="passport">
					</div>
				</div>
				<div class="row list-inline">
					<div class="col-md-3">
						<label for="driver"><f:message key="order.boolean.driver" /></label>
					</div>
					<div class="col-md-9">
						<input type="checkbox" id="driver" name="driver">
					</div>
				</div>
				<div class="row list-inline">
					<div class="col-md-3">
						<label for="startDate"><f:message key="order.startDate" />:
						</label>
					</div>
					<div class="col-md-9">
						<input type="date" required="" class="form-control" id="startDate"
							name="startDate">
					</div>
				</div>
				<div class="row list-inline">
					<div class="col-md-3">
						<label for="endDate"><f:message key="order.endDate" />: </label>
					</div>
					<div class="col-md-9">
						<input type="date" required="" class="form-control" id="endDate"
							name="endDate">
					</div>
				</div>
			</div>
			<div class="card-footer">
				<button type="submit" class="btn btn-primary">
					<f:message key="manager.button.confirm" />
				</button>
			</div>
		</form>
	</div>
</div>
