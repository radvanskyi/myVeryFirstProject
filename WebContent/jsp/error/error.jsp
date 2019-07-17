<%@include file="/jsp/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<body>
<div class="col-lg-offset-5 col-lg-2">
    <p class="h3" style="color: red">
        <f:message key="error.badOrder"/>
    </p>
    <a href="${pageContext.request.contextPath}/return">
        <button class="btn btn-primary"><f:message key="manager.button.return"/></button>
    </a>
</div>

</body>
</html>