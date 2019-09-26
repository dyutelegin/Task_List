import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { TasksService } from '../tasks.service';
import { Tasks } from '../tasks';

@Component({
  selector: 'tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks: Observable<Tasks[]>;

  constructor(private tasksService: TasksService) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteTasks() {
    this.tasksService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.tasks = this.tasksService.getTasksList();
  }
}
