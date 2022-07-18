
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${taskList}" var="task">
    <tbody>
    <tr>
        <th scope="row">${task.id}</th>
        <td>${task.taskName}</td>
        <td>${task.taskDescription}</td>
        <td>${task.priority}</td>
        <td>
            <button class="btn btn-secondary" >Edit</button>
            <a class="btn btn-danger" href="${pageContext.request.contextPath}/tasks?action=delete&id=${task.id}" method="Pos">Delete</a>
        </td>
    </tr>
    </tbody>
</c:forEach>
