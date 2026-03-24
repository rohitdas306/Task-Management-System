package com.task.task_management.mapper;

import com.task.task_management.dto.TaskRequestDTO;
import com.task.task_management.dto.TaskResponseDTO;
import com.task.task_management.model.Task;

public class TaskMapper {
    //DTO->Entity
    public static Task toEntity(TaskRequestDTO dto){
        if (dto==null) return null;

        Task task=new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        return task;
    }
    //Entity -> DTO
    public static TaskResponseDTO toDTO(Task task){
        if (task==null) return null;

        TaskResponseDTO dto=new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        return dto;
    }
}
