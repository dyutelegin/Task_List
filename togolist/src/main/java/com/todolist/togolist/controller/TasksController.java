package com.todolist.togolist.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.togolist.model.Tasks;
import com.todolist.togolist.repo.TaskRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class TasksController {

    @Autowired
    TaskRepository repository;

    @GetMapping("/tasks")
    public List<Tasks> getAllTasks() {
        System.out.println("Get all Tasks...");

        List<Tasks> tasks = new ArrayList<>();
        repository.findAll().forEach(tasks::add);

        return tasks;
    }

    @PostMapping(value = "/tasks/create")
    public Tasks postTasks(@RequestBody Tasks tasks) {

        Tasks _tasks = repository.save(new Tasks(tasks.getNametask(), tasks.getDate()));
        return _tasks;
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTasks(@PathVariable("id") long id) {
        System.out.println("Delete Tasks with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("Tasks has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/tasks/delete")
    public ResponseEntity<String> deleteAllTasks() {
        System.out.println("Delete All Tasks...");

        repository.deleteAll();

        return new ResponseEntity<>("All tasks have been deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "tasks/date/{date}")

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Tasks> updateTasks(@PathVariable("id") long id, @RequestBody Tasks tasks) {
        System.out.println("Update Tasks with ID = " + id + "...");

        Optional<Tasks> tasksData = repository.findById(id);

        if (tasksData.isPresent()) {
            Tasks _tasks = tasksData.get();
            _tasks.setNametask(tasks.getNametask());
            _tasks.setDate(tasks.getDate());
            return new ResponseEntity<>(repository.save(_tasks), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
