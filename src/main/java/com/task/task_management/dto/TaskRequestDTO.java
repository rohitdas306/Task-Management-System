package com.task.task_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDTO {
    private String title;
    private String description;
    private String status;
}
