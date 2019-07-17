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

<c:forEach var="manager" items="${list}">
	<div class="panel panel-primary">
		<div class="row panel-body">
			<div class="col-md-12">
				<div class="col-md-3">
					<p>
						<f:message key="user.email" />
						: ${manager.email}
					</p>
				</div>
				<div class="col-md-3">
					<p>
						<f:message key="user.password" />
						: ${manager.password}
					</p>
				</div>
				<div class="col-md-3">
					<p>
						<f:message key="user.firstname" />
						: ${manager.firstName}
					</p>
				</div>
				<div class="col-md-3">
					<p>
						<f:message key="user.lastname" />
						: ${manager.lastName}
					</p>
				</div>
				======================
			</div>
		</div>
	</div>
</c:forEach>