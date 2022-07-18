package com.codo.integrador.services;

import com.codo.integrador.config.SqlConnectionConfig;
import com.codo.integrador.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private static final String GET_ALL_QUERY = "SELECT * FROM tasks";
    private static final String ADD_QUERY = "INSERT INTO tasks VALUES (null, ?, ?, ?)";
    private static final String DELETE_QUERY = "DELETE FROM tasks WHERE id = ?";

    @Override
    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();

        try (Connection connection = SqlConnectionConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = ps.executeQuery();) {


            while (rs.next()) {
                Integer id = rs.getInt("id");
                String taskName = rs.getString("taskName");
                String taskDescription = rs.getString("taskDescription");
                String priority = rs.getString("priority");
                Task task = new Task(id, taskName, taskDescription, priority);
                System.out.println(task);
                tasks.add(task);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Error reading task in database...");
        }
        return tasks;
    }


    @Override
    public Task getTask(int id) {
        return null;
    }

    @Override
    public int addTask(Task task) {
        int addCount= 0;
        try (Connection connection = SqlConnectionConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(ADD_QUERY)){
            ps.setString(1,task.getTaskName());
            ps.setString(2,task.getTaskDescription());
            ps.setString(3,task.getPriority());
            addCount=ps.executeUpdate();
        }catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener alumnos", ex);
        }
        return addCount;
    }

    @Override
    public int updateTask(Task task) {
        return 0;
    }

    @Override
    public int removeTask(int id) {
        int deleteCount = 0;
        try (Connection connection = SqlConnectionConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)){
            ps.setInt(1,id);
            deleteCount=ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener alumnos", ex);
        }
        return deleteCount;
    }
}
