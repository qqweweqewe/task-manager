package net.qwew.task_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import net.qwew.task_api.entity.Task;
import net.qwew.task_api.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    Gson gson;

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody Task newTask) {
        taskService.createTask(newTask);
        return ResponseEntity.ok().body("created " + newTask);
    }

    @GetMapping
    public ResponseEntity<String> getAllTasks() {
        List<Task> tasks = taskService.getTasks();
        
        String body = gson.toJson(tasks);
    
        return ResponseEntity.ok().body(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTask(@PathVariable long id) {
        Task task = taskService.getTask(id);
        return ResponseEntity.ok().body(gson.toJson(task));
    }
    
    @PatchMapping("/{id}/done")
    public Task markDone(@PathVariable long id) {
        Task task = taskService.markDone(id);
        return task;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        Task deletedTask = taskService.deleteTask(id);
        return ResponseEntity.ok().body("deleted " + deletedTask.toString());
    }

    @DeleteMapping
    public ResponseEntity<String> removeDone() {
        taskService.removeDone();
        return ResponseEntity.ok().body("removed completed tasks");
    }
}
