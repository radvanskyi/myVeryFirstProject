<%@include file="/jsp/taglibs.jsp" %>
<c:forEach var="manager" items="${list}">
    <div class="panel panel-primary">
        <div class="row panel-body">
            <div class="col-md-12">
                    <div class="col-md-3">
                        <p><f:message key="user.email"/>: ${manager.email}</p>
                    </div>
                    <div class="col-md-3">
                        <p><f:message key="user.password"/>: ${manager.password}</p>
                    </div>
                    <div class="col-md-3">
                        <p><f:message key="user.firstname"/>: ${manager.firstName}</p>
                    </div>
                    <div class="col-md-3">
                        <p><f:message key="user.lastname"/>: ${manager.lastName}</p>
                    </div>
               </div>
        </div>
    </div>
</c:forEach>