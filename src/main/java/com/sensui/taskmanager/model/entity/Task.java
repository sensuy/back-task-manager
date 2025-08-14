package com.sensui.taskmanager.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = Task.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode
public class Task {

    public static final String TABLE_NAME = "tasks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "task_title";
    public static final String COLUMN_COMPLETED = "task_completed";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private Long id;

    @Column(name = COLUMN_TITLE, nullable = false)
    private String title;

    @Column(name = COLUMN_COMPLETED, nullable = false)
    private Boolean completed;

    public Task setCompleted(Boolean completed) {
        this.completed = completed;
        if (this.completed == null) {
            this.completed = false;
        }
        return this;
    }
}
