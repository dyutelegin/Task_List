package com.todolist.togolist.repo;

import org.springframework.data.repository.CrudRepository;

import com.todolist.togolist.model.Tasks;

public interface TaskRepository extends CrudRepository<Tasks, Long> {

}
