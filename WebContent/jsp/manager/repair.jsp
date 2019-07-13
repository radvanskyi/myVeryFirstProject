<%@include file="/jsp/taglibs.jsp" %>

<html>
<body>
<div class="panel panel-primary col-lg-offset-2 col-lg-8">
    <div class="panel-heading">
        <p class="h3"><f:message key="heading.repairPage"/></p>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-lg-6">
                <p class="h3"><f:message key="car"/></p><br/>

                <p>mark: ${order.car.mark}</p><br/>

                <p>model: ${order.car.model}</p><br/>

                <p>class: ${order.car.carClass.name}</p><br>

                <p>cost (per day): ${order.car.price}</p><br/>

            </div>
            <div class="col-lg-6">
                <p class="h3"><f:message key="user"/></p><br/>

                <p>email: ${order.user.email}</p><br/>

                <p>passport: ${order.passport}</p><br/>
            </div>
        </div>
        <div class="row">
            <form class="form-group" action="${pageContext.request.contextPath}/createRepairOrder" method="post">
                <label for="check"><f:message key="check"/>: <input type="number" name="id" value="${order.id}"
                                                                      id="check" ></label><br/>

                <div class="col-lg-3">
                    <label for="startDate"><f:message key="order.startDate"/> : </label>
                </div>
                <div class="col-lg-9">
                    <input type="date" required="" class="form-control" id="startDate" name="startDate">
                </div>
                <div class="col-lg-3">
                    <label for="endhDate"><f:message key="order.endDate"/> : </label>
                </div>
                <div class="col-lg-9">
                    <input type="date" required="" class="form-control" id="endDate" name="endDate">
                </div>
                <label><f:message key="check.description"/> : </label><br/>
                <textarea rows="4" class="form-control" name="description"></textarea><br/>
                <label for="price"><f:message key="car.price"/> : </label>
                <input type="number" name="price" class="form-control" id="price"/>
                <button class="btn btn-primary" type="submit"><f:message key="manager.button.createOrder"/></button>
            </form>
            <div>
                <a href="${pageContext.request.contextPath}/return">
                    <button class="btn btn-danger"><f:message key="manager.button.return"/></button>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
