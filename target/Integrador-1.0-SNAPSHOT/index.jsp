
<jsp:include page="WEB-INF/shared/startHTML.jsp"></jsp:include>
<jsp:include page="WEB-INF/shared/startHead.jsp"></jsp:include>
<title>Home</title>
<jsp:include page="WEB-INF/shared/endHead.jsp"></jsp:include>
<jsp:include page="WEB-INF/shared/nav.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h2>Integrador Codo A Codo</h2>
        </div>
        <div class="col-12">
            <a href="${pageContext.request.contextPath}/tasks" class="btn btn-primary">
                Task List
            </a>
        </div>
    </div>
</div>


<jsp:include page="WEB-INF/shared/endHTML.jsp"></jsp:include>

