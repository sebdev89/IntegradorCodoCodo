<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/shared/startHTML.jsp"></jsp:include>
<jsp:include page="WEB-INF/shared/startHead.jsp"></jsp:include>
<title>Home</title>
<jsp:include page="WEB-INF/shared/endHead.jsp"></jsp:include>
<jsp:include page="WEB-INF/shared/nav.jsp"></jsp:include>

<div class="container">
<c:choose>
    <c:when test="${taskList != null && !taskList.isEmpty()}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Priority</th>
            </tr>
            </thead>
        <jsp:include page="WEB-INF/pages/tasks/components/bodyTableTask.jsp" />
        </table>
    </c:when>
    <c:otherwise>
        <div class="row mt-4">
            <div class="col-12">
                <p class="display-5 text-danger">Ooops! Parece que no hay tareas agregadas...</p>
            </div>
        </div>
    </c:otherwise>

</c:choose>
</div>

<jsp:include page="WEB-INF/shared/endHTML.jsp"></jsp:include>


