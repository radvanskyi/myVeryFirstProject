<%@include file="/jsp/taglibs.jsp" %>
<c:if test="${marks != null}">
    <div class="container">
        <div class="col-lg-3">
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><f:message
                        key="car.setMark"/><span
                        class="caret"></span></button>
                <ul class="dropdown-menu">
                    <c:forEach var="mark" items="${marks}">
                        <li><a href="${pageContext.request.contextPath}/carSort?mark=${mark}">${mark}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-lg-3">
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><f:message
                        key="car.setCarClass"/><span
                        class="caret"></span></button>
                <ul class="dropdown-menu">
                    <c:forEach var="carClass" items="${classes}">
                        <li>
                            <a href="${pageContext.request.contextPath}/carSort?carClass=${carClass}">${carClass}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-lg-3">
            <a href="${pageContext.request.contextPath}/carSort?price=true">
                <button class="btn btn-primary"><f:message key="user.sortByPrice"/></button>
            </a>
        </div>
        <div class="col-lg-3">
            <a href="${pageContext.request.contextPath}/carSort?model=true">
                <button class="btn btn-primary"><f:message key="user.sortByModel"/></button>
            </a>
        </div>
    </div>
</c:if>