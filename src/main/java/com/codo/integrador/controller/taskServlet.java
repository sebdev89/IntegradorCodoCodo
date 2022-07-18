package com.codo.integrador.controller;

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

    @Override
    public void init() throws ServletException {
        message = "tasks";
        this.taskService = new TaskServiceImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setAttribute("taskList", taskService.getTasks());
        request.getRequestDispatcher(URI_LIST).forward(request, response);

    }
}
