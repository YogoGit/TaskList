package services;

import models.Task;

import java.util.List;

public interface TaskService {

    public void addTask(Task task);

    public List<Task> getAllTasks();

}
