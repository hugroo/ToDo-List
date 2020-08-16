package com.hugroo.todoapi.controller;

import com.hugroo.todoapi.entity.Task;
import com.hugroo.todoapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/tasks")
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    ResponseEntity<List<Task>> tasks(){
        List<Task> tasks = taskService.tasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    ResponseEntity<Task>  searchTask(@PathVariable Long id) {
        Task result = taskService.getTask(id);
        return ResponseEntity.ok(result);
    }


    @PostMapping
    ResponseEntity<Task> addTask(@RequestBody Task task){
        Task createdTask = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping
    ResponseEntity<Task> editTask(@RequestBody Task task){
        Task updatedTask = taskService.saveTask(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
