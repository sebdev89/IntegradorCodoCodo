package com.codo.integrador.controller;

import com.codo.integrador.model.Task;
import com.codo.integrador.services.TaskService;
import com.codo.integrador.services.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "taskServlet", value = "/tasks")
public class taskServlet extends HttpServlet {

    private String message;
    private TaskService taskService;

    private final String URI_LIST = "listTasks.jsp";
    private final String URI_EDIT = "WEB-INF/pages/tasks/editTask.jsp";

    @Override
    public void init() throws ServletException {
        message = "tasks";
        this.taskService = new TaskServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        Integer id;
        Task task;
        action = action == null ? "" : action;
        switch (action) {
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                task = taskService.getTask(id);
                request.setAttribute("taskToEdit", task);
                request.getRequestDispatcher(URI_EDIT).forward(request, response);
                break;
            default:
                request.setAttribute("taskList", taskService.getTasks());
                request.getRequestDispatcher(URI_LIST).forward(request, response);
        }
    }

        public void doPost (HttpServletRequest request, HttpServletResponse response) throws
        IOException, ServletException {
            response.setContentType("text/html");


            String action = request.getParameter("action");
            Integer id;
            Task task;
            action = action == null ? "" : action;

            switch (action) {
                case "add":
                    task = new Task();
                    loadTask(task, request);
                    taskService.addTask(task);
                    break;
                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    task = taskService.getTask(id);
                    loadTaskByParams(task, request);
                    taskService.updateTask(task);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    taskService.removeTask(id);
                    break;
            }
            doGet(request, response);
        }

        private void loadTask (Task task, HttpServletRequest request){
            task.setTaskName(request.getParameter("taskName"));
            task.setTaskDescription(request.getParameter("taskDescription"));
            task.setPriority(request.getParameter("priority"));
        }

    private void loadTaskByParams (Task task, HttpServletRequest request){
        task.setTaskName(request.getParameter("taskName"));
        task.setTaskDescription(request.getParameter("taskDescription"));
        task.setPriority(request.getParameter("priority"));
    }
    }
