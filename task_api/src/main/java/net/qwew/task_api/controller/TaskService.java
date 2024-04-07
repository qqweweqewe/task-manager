package net.qwew.task_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.qwew.task_api.entity.Task;
import net.qwew.task_api.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task newTask) {
        return taskRepository.save(newTask);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(long id) {
        return taskRepository.findById(id).get();
    }

    public Task markDone(long id) {
        Task task = getTask(id);
        task.setDone(true);
        return taskRepository.save(task);
    }

    public Task deleteTask(long id) {
        Task task = getTask(id);
        taskRepository.delete(task);
        return task;
    }
}
