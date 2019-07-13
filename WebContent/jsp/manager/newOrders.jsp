<%@include file="/jsp/taglibs.jsp"%>

<div class="container col-lg-12">
    <c:forEach var="check" items="${accepting}">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <f:message key="heading.orderForConfrim"/>
            </div>
            <div class="panel-body">
                <c:forEach var="order" items="${check.orders}">
                    <c:set var="Norder" value="${order}"/>
                    <div class="panel-body">
                        <div class="col-lg-4">
                            <f:message key="car.mark"/>: ${order.car.mark}<br/>
                            <f:message key="car.name"/>: ${order.car.model}<br/>
                            <f:message key="car.carClass"/>: ${order.car.carClass.name}<br/>
                            <f:message key="car.costPerDay"/>: ${order.car.price}<br/>
                        </div>
                        <div class="col-lg-4">
                            <f:message key="user"/> <f:message key="order.passport"/>: ${order.passport}<br/>
                            <f:message key="order.startDate"/>: ${order.startDate}<br/>
                            <f:message key="order.endDate"/>: ${order.endDate}<br/>
                            <f:message key="order.driver"/>: ${order.driver}<br/>
                            <f:message key="order"/> <f:message key="global.status"/>: ${order.status.name}<br/>
                        </div>
                    </div>
                </c:forEach>
                <div class="col-lg-3">
                    <p class="h3"><f:message key="user"/></p><br/>

                    <p><f:message key="user.email"/>: ${Norder.user.email}</p><br/>

                    <p><f:message key="user.password"/>: ${Norder.user.password}</p><br/>

                    <p><f:message key="user.firstname"/>: ${Norder.user.firstName}</p><br/>

                    <p><f:message key="user.lastname"/>: ${Norder.user.lastName}</p><br/>
                </div>

                <form class="form-group" action="${pageContext.request.contextPath}/cancelOrder" method="post">
                    <div class="col-lg-3">
                        <p class="h3"><f:message key="check"/>: <input type="number" name="id"
                                                                         value="${check.id}" /></p><br/>
                        <label for="desc"><f:message key="check.description"/>: </label><br/>
                            <textarea class="form-control" name="description" rows="2"
                                      id="desc">${check.description}</textarea>

                        <div class="h3">
                            <f:message key="check.totalCost"/>: ${check.price}<br/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-danger"><f:message key="manager.button.cancel"/></button>
                </form>
                <form method="post" action="${pageContext.request.contextPath}confirmCheck">
                    <input name="id" value="${check.id}" >
                    <button type="submit" class="btn btn-success"><f:message key="manager.button.confirm"/></button>
                </form>
            </div>
        </div>
    </c:forEach>

    <c:forEach var="check" items="${returned}">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <f:message key="heading.returnedCar"/>
            </div>
            <div class="panel-body">
                <c:forEach var="order" items="${check.orders}">
                    <div class="panel-body">
                        <c:set var="status" value="${order.status.name}"/>
                        <c:set var="Norder" value="${order}"/>
                        <div class="col-lg-3">
                            <f:message key="car.mark"/>: ${order.car.mark}<br/>
                            <f:message key="car.model"/>: ${order.car.model}<br/>
                        </div>
                        <div class="col-lg-3">
                            <f:message key="user"/> <f:message key="order.passport"/>: ${order.passport}<br/>
                            <f:message key="order.startDate"/>: ${order.startDate}<br/>
                            <f:message key="order.endDate"/>: ${order.endDate}<br/>
                            <f:message key="order.driver"/>: ${order.driver}<br/>
                            <f:message key="order"/> <f:message key="global.status"/>: ${order.status.name}<br/>
                        </div>
                        <div class="col-lg-3">
                            <c:if test="${order.status.name=='returned'}">
                                <a href="${pageContext.request.contextPath}/makeRepairPage?id=${order.id}">
                                    <button class="btn btn-warning"><f:message key="manager.button.repair"/></button>
                                </a>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
                <div class="col-lg-3">
                    <p class="h3"><f:message key="user"/></p><br/>

                    <p><f:message key="user.email"/>: ${Norder.user.username}</p><br/>

                    <p class="h3"><f:message key="check"/></p><br/>

                    <p><f:message key="check.description"/>: ${check.description}</p><br/>

                    <p><f:message key="check.totalCost"/>: ${check.price}</p>

                    <form method="post" action="${pageContext.request.contextPath}/finishOrder">
                        <input name="id" value="${check.id}" >
                        <button type="submit" class="btn btn-primary"><f:message
                                key="manager.button.accept"/></button>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
</div>