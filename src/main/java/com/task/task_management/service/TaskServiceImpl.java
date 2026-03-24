package com.task.task_management.service;

import com.task.task_management.dto.TaskRequestDTO;
import com.task.task_management.dto.TaskResponseDTO;
import com.task.task_management.mapper.TaskMapper;
import com.task.task_management.model.Task;
import com.task.task_management.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repo;

    public TaskServiceImpl(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<TaskResponseDTO> getAllTask() {
        List<Task> taskList=repo.findAll();
        List<TaskResponseDTO> dtoList=new ArrayList<>();
        for(Task task:taskList){
            TaskResponseDTO dto=TaskMapper.toDTO(task);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public TaskResponseDTO getTaskById(Long id) {
        Task task=repo.findById(id).orElseThrow(()->new RuntimeException("Task not Found"));
        return TaskMapper.toDTO(task);
    }

    @Override
    public TaskResponseDTO saveTask(TaskRequestDTO dto) {
        Task task= TaskMapper.toEntity(dto);
        Task saved=repo.save(task);
        return TaskMapper.toDTO(saved);
    }

    @Override
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO dto) {
        Task task=repo.findById(id).orElseThrow(()->new RuntimeException("Task not found"));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        Task updated=repo.save(task);
        return TaskMapper.toDTO(updated);
    }

    @Override
    public void deleteTask(Long id) {
        Task task=repo.findById(id).orElseThrow(()->new RuntimeException("Task not found"));
        repo.delete(task);
    }
}
