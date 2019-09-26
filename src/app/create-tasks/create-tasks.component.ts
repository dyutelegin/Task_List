import { Component, OnInit } from '@angular/core';

import { Tasks } from '../tasks';
import { TasksService } from '../tasks.service';

@Component({
  selector: 'create-tasks',
  templateUrl: './create-tasks.component.html',
  styleUrls: ['./create-tasks.component.css']
})
export class CreateTasksComponent implements OnInit {

  tasks: Tasks = new Tasks();
  submitted = false;

  constructor(private tasksService: TasksService) { }

  ngOnInit() {
  }

  newTasks(): void {
    this.submitted = false;
    this.tasks = new Tasks();
  }

  save() {
    this.tasksService.createTasks(this.tasks)
      .subscribe(data => console.log(data), error => console.log(error));
    this.tasks = new Tasks();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
