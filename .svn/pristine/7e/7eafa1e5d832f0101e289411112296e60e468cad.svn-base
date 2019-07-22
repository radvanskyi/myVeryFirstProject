<%@include file="/jsp/taglibs.jsp"%>

<div class="row">
	<c:forEach var="user" items="${list}">
		<div class="col-md-3">
			<div class="card">
				<div class="card-body">
					<p>
						<f:message key="user.email" />
						: ${user.email}
					</p>
					<p>
						<f:message key="user.password" />
						: ${user.password}
					</p>
					<p>
						<f:message key="user.firstName" />
						: ${user.firstName}
					</p>
					<p>
						<f:message key="user.lastName" />
						: ${user.lastName}
					</p>
					<p>
						<f:message key="user.role" />
						: ${user.role.name}
					</p>
				</div>
				<div class="card-footer">
					<c:choose>
						<c:when test="${user.role.name=='blocked'}">
							<a
								href="${pageContext.request.contextPath}/blockUser?id=${user.id}&blocked=true">
								<input name="id" value="${user.id}" hidden>
								<button type="button" class="btn btn-success">
									<f:message key="admin.button.unblock" />
								</button>
							</a>
							<button type="button" class="btn btn-danger" disabled>
								<f:message key="admin.button.block" />
							</button>
						</c:when>
						<c:otherwise>
							<button type="button" class="btn btn-success" disabled>
								<f:message key="admin.button.unblock" />
							</button>
							<a
								href="${pageContext.request.contextPath}/blockUser?id=${user.id}&blocked=false">
								<input name="id" value="${user.id}" hidden>
								<button type="submit" class="btn btn-danger">
									<f:message key="admin.button.block" />
								</button>
							</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<%@include file="/jsp/foot.jsp"%>