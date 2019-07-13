<%@include file="/jsp/taglibs.jsp" %>

<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>

<f:setLocale value="${language}"/>
<f:setBundle basename="controller.internationalization.i18n.lang"/>

<html>
<%@ include file="/jsp/head.jsp" %>
<body>
<div id="wrapper">

    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
        <div class="header-right">
            <c:choose>
                <c:when test="${empty sessionScope.role}">
                    <div class="col-lg-4">
                        <form class="form-group">
                            <select id="language" class="form-control" name="language" onchange="submit()">
                                <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
                                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                            </select>
                        </form>
                    </div>
                    <div class="col-lg-8">
                        <form class="form-inline" method="post" action="${pageContext.request.contextPath}/login">
                            <c:choose>
                                <c:when test="${language=='ru_RU'}">
                                    <input name="locale" value="ru" />
                                </c:when>
                                <c:otherwise>
                                    <input name="locale" value="${language}" />
                                </c:otherwise>
                            </c:choose>
                            <input class="form-control" placeholder="<f:message key="enter.email"/>" type="text"
                                   name="email"
                                   required="">
                            <input class="form-control" placeholder="<fmt:message key="enter.password"/>"
                                   type="password" required=""
                                   name="password">

                            <button type="submit" class="btn btn-primary"><f:message key="button.signin"/></button>
                        </form>
                        <div>
                            <a href="${pageContext.request.contextPath}/jsp/authentication/registration.jsp">
                                <button class="btn btn-warning"><f:message key="button.register"/></button>
                            </a>
                        </div>
                    </div>
                </c:when>

                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger" title="Logout"><i
                            class="btn-danger"><f:message key="button.logout"/></i></a>
                </c:otherwise>
            </c:choose>

        </div>
    </nav>
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <div class="user-img-div">
                        <div class="inner-text">
                            <p>${username}</p>
                        </div>
                    </div>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/carList"><i class="fa"></i><f:message
                            key="admin.carlist"/></a>
                </li>
                <c:if test="${not empty sessionScope.role}">
                    <li>
                        <a href="${pageContext.request.contextPath}/userOrders"><i class="fa"></i><f:message
                                key="user.myOrders"/></a>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
    
    <div id="page-wrapper">
        <%@include file="/jsp/customer/customerFilter.jsp" %>
        <div id="page-inner">

            <%@include file="/jsp/customer/carList.jsp" %>

            <c:if test="${not empty sessionScope.role}">
                <%--User Orders List--%>
                <%@include file="/jsp/customer/customerOrders.jsp" %>
            </c:if>

        </div>
    </div>
</div>
<!-- /. WRAPPER  -->
</body>
</html>
