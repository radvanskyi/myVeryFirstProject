<%@include file="/jsp/taglibs.jsp" %>
<c:forEach var="user" items="${list}">
    <div class="panel panel-primary">
        <div class="row panel-body">
            <div class="col-md-12">
                <div class="col-md-2">
                    <p><f:message key="user.email"/>: ${user.email}</p>
                </div>
                <div class="col-md-2">
                    <p><f:message key="user.password"/>: ${user.password}</p>
                </div>
                <div class="col-md-2">
                    <p><f:message key="user.firstname"/>: ${user.firstName}</p>
                </div>
                <div class="col-md-2">
                    <p><f:message key="user.lastname"/>: ${user.lastName}</p>
                </div>
                <div class="col-md-2">
                    <p><f:message key="user.role"/>: ${user.role.name}</p>
                </div>
                <div class="col-md-2 ">
                    <c:choose>
                        <c:when test="${user.role.name=='blocked'}">
                            <a href="${pageContext.request.contextPath}/setBlocked?id=${user.id}&blocked=true">
                                <button type="button" class="btn btn-success"><f:message
                                        key="admin.button.unblock"/></button>
                            </a>
                            <button type="button" class="btn btn-danger" disabled><f:message
                                    key="admin.button.block"/></button>
                        </c:when>
                        <c:otherwise>
                            <button type="button" class="btn btn-success" disabled><f:message
                                    key="admin.button.unblock"/></button>
                            <a href="${pageContext.request.contextPath}/setBlocked?id=${user.id}&blocked=false">
                                <button type="submit" class="btn btn-danger"><f:message
                                        key="admin.button.block"/></button>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</c:forEach>