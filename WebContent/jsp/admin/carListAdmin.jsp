<%@include file="/jsp/taglibs.jsp"%>



<form method="post" action="${pageContext.request.contextPath}/addCar"
	class="border-bottom mb-2 pb-2">
		<div class="row">
			<div class="col-md-2">
				<label for="mark"><f:message key="car.mark" />: ${car.mark}</label>
				<input id="mark" type="text" required="" class="form-control"
					name="mark">
			</div>
			<div class="col-md-2">
				<label for="model"><f:message key="car.model" />:
					${car.model}</label> <input class="form-control" id="model" required=""
					name="model" />
			</div>
			<div class="col-md-2">
				<label for="price"><f:message key="car.price" />:
					${car.price}</label> <input id="price" name="price" class="form-control"
					required="" />
			</div>
			<div class="col-md-2">
				<label for="carClass"><f:message key="car.carClass" />:${car.carClass.id}</label> 
				<select class="custom-select" id="carClass" name="carClass">
				<c:forEach var="carClass" items="${classes}">
				<option value="${carClass.getId()}">${carClass.getName()}</option>
					</c:forEach>
			</select>

		</div>
			<div class="col-md-4 list-inline align-self-end">
				<button type="submit" class="btn btn-info">
					<f:message key="admin.button.addCar" />
				</button>
			</div>
		</div>
</form>
<c:forEach var="car" items="${list}">
	<div class="row">
			<div class="col-md-2">
				<label for="mark"><f:message key="car.mark" />: ${car.mark}</label>
			</div>
			<div class="col-md-2">
				<label for="model"><f:message key="car.model" />:
					${car.model}</label>
			</div>
			<div class="col-md-1">
				<label for="price"><f:message key="car.price" />:
					${car.price}</label>
			</div>
			<div class="col-md-1">
				<label for="carClass"><f:message key="car.carClass" />:
					${car.carClass.name}</label>
			</div>
			<div class="col-md-2">
				<label for="status"><f:message key="global.status" />:
					${car.status.name}</label>
			</div>
		<div class="col-md-2">
			<form class="form-group"
				action="${pageContext.request.contextPath}/editCarPage"
				method="post">

				<input name="id" value="${car.id}" hidden>
				<button type="submit" class="btn btn-success">
					<f:message key="admin.button.edit" />
				</button>

			</form>
		</div>
		<div class="col-md-2">
			<form method="post"
				action="${pageContext.request.contextPath}/deleteCar">
				<input name="id" value="${car.id}" hidden>
				<button type="submit" name="rent" class="btn btn-danger">
					<f:message key="admin.button.delete" />
				</button>
			</form>
		</div>
	</div>

</c:forEach>
<%@include file="/jsp/foot.jsp"%>
