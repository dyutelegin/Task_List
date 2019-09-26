import { Component, OnInit, Input } from '@angular/core';
import { TasksService } from '../tasks.service';
import { Tasks } from '../tasks';

import { TasksListComponent } from '../tasks-list/tasks-list.component';

@Component({
  selector: 'tasks-details',
  templateUrl: './tasks-details.component.html',
  styleUrls: ['./tasks-details.component.css']
})
export class TasksDetailsComponent implements OnInit {

  @Input() tasks: Tasks;

  constructor(private tasksService: TasksService, private listComponent: TasksListComponent) { }

  ngOnInit() {
  }

  deleteTasks() {
    this.tasksService.deleteTasks(this.tasks.id)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }
}
