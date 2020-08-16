package com.hugroo.todoapi.service;

import com.hugroo.todoapi.dao.TaskRepository;
import com.hugroo.todoapi.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl  implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> tasks() {
        return (List<Task>) taskRepository.findAll();
    }
}
