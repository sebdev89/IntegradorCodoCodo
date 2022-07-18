<h1>TITULO</h1>
<div class="modal fade" id="modalAddTask" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add Task</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form id="formAddTask" action="${pageContext.request.contextPath}/tasks?action=add"
                  method="post" class="was-validated">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-6 mb-3">
                            <label for="taskName" class="form-label">Task Name</label>
                            <input type="text" class="form-control" id="taskName" name="taskName" required>
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="taskDescription" class="form-label">Task Description</label>
                            <input type="text" class="form-control" id="taskDescription" name="taskDescription" required>
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="priority" class="form-label">Priority</label>
                            <input type="text" class="form-control" id="priority" name="priority" required>
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
