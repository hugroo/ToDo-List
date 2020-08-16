package com.hugroo.todoapi.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * Entity of Task
 * @author hugroo
*/
@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean isCompleted;

}
