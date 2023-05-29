package com.example._days_challenge.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Task {
    @Id @GeneratedValue
    @Column(name = "task_id")
    private Long id;

    private Boolean isDone;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Builder
    public Task(Plan plan, Boolean isDone, String content) {
        this.plan = plan;
        this.isDone = isDone;
        this.content = content;
    }

    public static Task toEntity(Plan plan, Task task) {
        return Task.builder()
                .plan(plan)
                .isDone(task.getIsDone())
                .content(task.getContent())
                .build();
    }
}
