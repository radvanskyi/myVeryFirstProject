<%@include file="/jsp/taglibs.jsp"%>

	<div class="col-lg-12 row center-block">
		<div class="col-lg-offset-5 col-lg-2">
			<h3>
				<f:message key="registration" />
			</h3>

			<form method="post"
				action="${pageContext.request.contextPath}/registration"
				class="form-group" id="register_form">
				<div>
					<input name="email" placeholder="<f:message key="enter.email"/>"
						type="email" required="" class="form-control">
					<c:if test="${errorMsg}">
						<tr>
							<td style="color: red">${errorMsg }</td>
						</tr>
					</c:if>
				</div>
				<div>
					<input name="password"
						placeholder="<f:message key="enter.password"/>" type="password"
						required="" class="form-control">
				</div>
				<div>
					<input name="firstName" required=""
						placeholder="<f:message key="enter.firstName"/>"
						class="form-control" type="text">
				</div>
				<div>
					<input name="lastName" required=""
						placeholder="<f:message key="enter.lastName"/>"
						class="form-control" type="text">
				</div>
				<button type="submit" name="register" id="register_button"
					class="col-lg-12 btn btn-success center-block">
					<f:message key="button.register" />
				</button>
				<c:choose>
					<c:when test="${language=='ru_RU'}">
						<input name="locale" value="ru" hidden />
					</c:when>
					<c:otherwise>
						<input name="locale" value="${language}" hidden />
					</c:otherwise>
				</c:choose>
			</form>
		</div>
	</div>
<%@include file="/jsp/foot.jsp"%>