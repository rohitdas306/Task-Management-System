package com.task.task_management.service;

import com.task.task_management.dto.TaskRequestDTO;
import com.task.task_management.dto.TaskResponseDTO;

import java.util.List;

public interface TaskService {
    List<TaskResponseDTO> getAllTask();
    TaskResponseDTO getTaskById(Long id);
    TaskResponseDTO saveTask(TaskRequestDTO dto);
    TaskResponseDTO updateTask(Long id,TaskRequestDTO dto);
    void deleteTask(Long id);
}
