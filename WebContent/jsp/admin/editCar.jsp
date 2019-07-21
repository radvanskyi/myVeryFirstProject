<%@include file="/jsp/taglibs.jsp"%>

<c:forEach var="car" items="${cars}">
	<div class="panel panel-primary">
		<div class="row panel-body">
			<div class="col-md-12">
				<form class="form-group"
					action="${pageContext.request.contextPath}/editCar" method="post">
					<div class="col-md-2">
						<input name="id" value="${car.id}" hidden />
						<div class="col-md-6">
							<label for="mark"><f:message key="car.mark" />:
								${car.mark}</label>
						</div>
					</div>
					<div class="col-md-2">
						<label for="model"><f:message key="car.model" />:
							${car.model}</label>
					</div>
					<div class="col-md-2">
						<label for="price"><f:message key="car.price" />: </label> <input
							id="price" name="price" value="${car.price}" required=""
							class="form-control list-inline" />
					</div>
					<div class="col-md-2">
						<div class="col-md-6">
							<label for="class"><f:message key="car.carClass" />:
								${car.carClass.name} </label>
						</div>
					</div>
					<div class="col-md-2">
						<div class="col-md-6">
							<label for="status"><f:message key="global.status" />:
								${car.status.name}</label>
						</div>
					</div>
					<div class="col-md-2">
						<button type="submit" class="btn btn-success">
							<f:message key="admin.button.edit" />
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</c:forEach>
<%@include file="/jsp/foot.jsp"%>