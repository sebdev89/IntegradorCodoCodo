<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../shared/startHTML.jsp"></jsp:include>
<jsp:include page="../../shared/startHead.jsp"></jsp:include>
<title>Editing task ${taskToEdit.taskName}</title>
<jsp:include page="../../shared/endHead.jsp"></jsp:include>
<jsp:include page="../../shared/nav.jsp"></jsp:include>

<div class="container">
    <h1>${pageContext.request.contextPath}</h1>
    <form id="formUpdateTask" action="${pageContext.request.contextPath}/tasks?action=update&id=${taskToEdit.id}" method="post">
        <div class="form-group">
            <label for="taskName">Task name</label>
            <input type="text" class="form-control" id="taskName"  name="taskName" value="${taskToEdit.taskName}">
        </div>
        <div class="form-group">
            <label for="taskDescription">Task Description</label>
            <input type="text" class="form-control" id="taskDescription" name="taskDescription" value="${taskToEdit.taskDescription}">
        </div>
        <div class="form-group">
            <label for="priority">Priority</label>
            <input type="text" class="form-control" id="priority" name="priority" value="${taskToEdit.priority}">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<jsp:include page="../../shared/endHTML.jsp"></jsp:include>
