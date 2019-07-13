<%@include file="/jsp/taglibs.jsp" %>

<html>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
        <div class="header-right">
            <a href="${pageContext.request.contextPath}/jsp/admin/regManager.jsp"><i
                    class="btn btn-warning"><f:message key="admin.button.regManager"/></i></a>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger" title="Logout"><i
                    class="btn-danger"><f:message key="button.logout"/></i></a>
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
                <li>
                    <a href="${pageContext.request.contextPath}/managerList"><i class="fa"></i><f:message
                            key="admin.managersList"/></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/userList"><i class="fa"></i><f:message
                            key="admin.usersList"/></a>
                </li>
            </ul>
        </div>

    </nav>
    <div id="page-wrapper">
        <div class="panel-group" id="page-inner">
            <c:if test="${cars!=null}">
                <div class="panel-body row">
                    <form method="post" action="${pageContext.request.contextPath}/addCar" class="form-group inline">
                        <div class="col-md-2">
                            <label for="mark"><f:message key="car.mark"/>: </label>
                            <input id="mark" type="text" required="" class="form-control" name="mark">
                        </div>
                        <div class="col-md-2">
                            <label for="model"><f:message key="car.model"/>: </label>
                            <input class="form-control" id="model" required="" name="model"/>
                        </div>
                        <div class="col-md-2">
                            <label for="price"><f:message key="car.price"/>: </label>
                            <input id="price" name="price" class="form-control" required=""/>
                        </div>
                        <div class="col-md-2">
                            <label for="class"><f:message key="car.carClass"/>: </label>
                            <input id="class" name="class" class="form-control" required=""/>
                        </div>
                        <div class="col-md-2 list-inline">
                            <button type="submit" class="btn btn-info"><f:message key="admin.button.addCar"/></button>
                        </div>
                    </form>
                </div>
            </c:if>

            <%@include file="/jsp/admin/carAdd.jsp" %>

            <%@include file="/jsp/admin/userList.jsp" %>

            <%@include file="/jsp/admin/managerList.jsp" %>

        </div>
    </div>
</div>
</body>
</html>
