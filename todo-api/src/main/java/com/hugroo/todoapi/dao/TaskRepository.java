package com.hugroo.todoapi.dao;

import com.hugroo.todoapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
public interface TaskRepository extends JpaRepository<Task, Long> {
}
