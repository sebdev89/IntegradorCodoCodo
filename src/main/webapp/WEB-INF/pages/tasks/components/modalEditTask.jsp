<h1>TITULO</h1>
<div class="modal fade" id="modalEditTask" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Edit Task</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form id="formEditTask" action="${pageContext.request.contextPath}/tasks?action=update"
                  method="post" class="was-validated">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-6 mb-3">
                            <label for="taskName" class="form-label">Task Name</label>
                            <input type="text" class="form-control" id="taskName" name="taskName" required value="${taskToEdit.taskName}">
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="taskDescription" class="form-label">Task Description</label>
                            <input type="text" class="form-control" id="taskDescription" name="taskDescription" required value="${taskToEdit.taskDescription}">
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="priority" class="form-label">Priority</label>
                            <input type="text" class="form-control" id="priority" name="priority" required value="${taskToEdit.priority}">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-success">Add</button>
                </div>
            </form>
        </div>
    </div>
</div>
