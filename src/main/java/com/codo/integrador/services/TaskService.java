package com.codo.integrador.services;

import com.codo.integrador.model.Task;

import java.util.List;

public interface TaskService {

    public List<Task> getTasks();

    public Task getTask(int id);


    public int addTask(Task task);


    public int updateTask(Task task);


    public int removeTask(int id);
}
