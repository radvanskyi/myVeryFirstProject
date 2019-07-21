<%@include file="/jsp/taglibs.jsp"%>

<div class="row">
	<c:forEach var="manager" items="${list}">
		<div class="col-md-3">
			<div class="card">
				<div class="card-body">
					<p>
						<f:message key="user.email" />
						: ${manager.email}
					</p>
					<p>
						<f:message key="user.password" />
						: ${manager.password}
					</p>
					<p>
						<f:message key="user.firstName" />
						: ${manager.firstName}
					</p>
					<p>
						<f:message key="user.lastName" />
						: ${manager.lastName}
					</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@include file="/jsp/foot.jsp"%>