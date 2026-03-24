package com.task.task_management.controller;

import com.task.task_management.dto.TaskRequestDTO;
import com.task.task_management.dto.TaskResponseDTO;
import com.task.task_management.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTask(){
        return ResponseEntity.ok(service.getAllTask());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok(service.getTaskById(id));
    }
    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO dto){
        return new ResponseEntity<>(service.saveTask(dto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id,@RequestBody TaskRequestDTO dto){
        return ResponseEntity.ok(service.updateTask(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
