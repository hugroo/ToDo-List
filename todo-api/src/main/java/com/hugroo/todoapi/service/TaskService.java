package com.hugroo.todoapi.service;

import com.hugroo.todoapi.entity.Task;

import java.util.List;

public interface TaskService {
    public Task getTask(Long id);
    public Task saveTask(Task task);
    public void deleteTask(Long id);
    public List<Task> tasks();
}
