<%@include file="/jsp/taglibs.jsp" %>

<c:forEach var="car" items="${cars}">
    <div class="panel panel-primary">
        <div class="row panel-body">
            <div class="col-md-12">
                <form class="form-group" action="${pageContext.request.contextPath}/editCar" method="post">
                    <div class="col-md-2">
                        <input name="id" value="${car.id}" />

                        <div class="col-md-6">
                            <label for="mark"><f:message key="car.mark"/>: </label>
                            <input id="mark" required="" type="text" class="form-control" value="${car.mark}"
                                   name="mark">
                        </div>
                    </div>
                    <div class="col-md-2">
                        <label for="model"><f:message key="car.model"/>: </label>
                        <input class="form-control" id="name" required="" value="${car.name}" name="name"/>
                    </div>
                    <div class="col-md-2">
                        <label for="price"><f:message key="car.price"/>: </label>
                        <input id="price" name="price" value="${car.price}" required="" class="form-control list-inline"/>
                    </div>
                    <div class="col-md-2">
                        <div class="col-md-6">
                            <label for="class"><f:message key="car.carClass"/>: </label>
                            <input id="class" name="class" value="${car.carClass.id}" required=""
                                   class="form-control list-inline"/>
                        </div>
                        <div class="col-md-6">
                            <p>${car.carClass.name}</p>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="col-md-6">
                            <label for="status"><f:message key="global.status"/>: </label>
                            <input class="form-control list-inline" id="status" name="status" required=""
                                   value="${car.status.id}"/>
                        </div>
                        <div class="col-md-6">
                            <p>${car.status.name}</p>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-success"><f:message key="admin.button.edit"/></button>
                    </div>
                </form>
                <div class="col-md-2">
                    <form method="post" action="${pageContext.request.contextPath}/deleteCar">
                        <input name="id" value="${car.id}">
                        <button type="submit" name="rent" class="btn btn-danger"><f:message
                                key="admin.button.delete"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</c:forEach>