<%@include file="/jsp/taglibs.jsp"%>

<div class="col-lg-4">
	<form class="form-group">
		<select id="language" class="form-control" name="language"
			onchange="submit()">
			<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
			<option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
		</select>
	</form>
</div>

<a href="${pageContext.request.contextPath}/return">
	<button class="btn btn-primary">
		<f:message key="manager.button.return" />
	</button>
</a> 
<br>
======================

<form method="post" action="${pageContext.request.contextPath}/addCar"
	class="form-group inline">
	<div class="col-md-2">
		<label for="mark"><f:message key="car.mark" />: ${car.mark}</label> <input
			id="mark" type="text" required="" class="form-control" name="mark">
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
		<label for="carClass"><f:message key="car.carClass" />:
			${car.carClass.id}</label> <input id="carClass" name="carClass"
			class="form-control" required="" />
	</div>
	<div class="col-md-2 list-inline">
		<button type="submit" class="btn btn-info">
			<f:message key="admin.button.addCar" />
		</button>
	</div>
</form>
======================

<c:forEach var="car" items="${list}">
	<div class="panel panel-primary">
		<div class="row panel-body">
			<div class="col-md-12">

				<form class="form-group"
					action="${pageContext.request.contextPath}/carListAdmin"
					method="post">
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
						<label for="price"><f:message key="car.price" />:
							${car.price}</label>
					</div>
					<div class="col-md-2">
						<div class="col-md-6">
							<label for="carClass"><f:message key="car.carClass" />:
								${car.carClass.name}</label>
						</div>
					</div>
					<div class="col-md-2">
						<div class="col-md-6">
							<label for="status"><f:message key="global.status" />:
								${car.status.name}</label>
						</div>
					</div>
				</form>

				<form class="form-group"
					action="${pageContext.request.contextPath}/editCarPage" method="post">
					<div class="col-md-2">
						<input name="id" value="${car.id}" hidden>
						<button type="submit" class="btn btn-success">
							<f:message key="admin.button.edit" />
						</button>
					</div>
				</form>

				<form method="post"
					action="${pageContext.request.contextPath}/deleteCar">
					<input name="id" value="${car.id}" hidden>
					<button type="submit" name="rent" class="btn btn-danger">
						<f:message key="admin.button.delete" />
					</button>
				</form>
			</div>
		</div>
	</div>
	======================
</c:forEach>