<%@include file="/jsp/taglibs.jsp"%>
<html>
<body>
<div class="col-lg-12 row center-block">
    <div class="col-lg-offset-5 col-lg-2">
        <h3><f:message key="registration"/></h3>

        <form method="post" action="${pageContext.request.contextPath}/addManager" class="form-group"
              id="register_form">
            <div>
                <input name="email" placeholder="<f:message key="enter.email"/>" type="text" required=""
                       class="form-control">
            </div>
            <div>
                <input name="password" placeholder="<f:message key="enter.password"/>" type="password" required=""
                       class="form-control">
            </div>
            <div>
                <input name="firstname" required="" placeholder="<f:message key="enter.firstName"/>"
                       class="form-control" type="text">
            </div>
            <div>
                <input name="lastname" required="" placeholder="<f:message key="enter.lastName"/>"
                       class="form-control" type="text">
            </div>
            <button type="submit" name="register" id="register_button" class="col-lg-12 btn btn-warning center-block">
                <f:message key="admin.button.regManager"/></button>
        </form>
    </div>
</div>

</body>
</html>
