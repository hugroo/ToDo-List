import { Component, OnInit } from '@angular/core';
import {TasksService} from "../tasks.service";
import {Task} from "./task"
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  providers: [TasksService],
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  tasks: Task[]
  editTask: Task

  constructor(private taskService: TasksService, private http: HttpClient) { }

  ngOnInit(): void {
    this.getTasks();
  }

  getTasks():void{
    this.taskService.getTasks().subscribe(tasks => (this.tasks = tasks));
  }

  add(title: string): void {
    this.editTask = undefined
    title = title.trim()
    if(!title){
      return
    }
    let newTask: Task = {title} as Task
    this.taskService.addTask(newTask).subscribe(()=> this.getTasks())
  }

  delete(task: Task): void {
    this.tasks = this.tasks.filter(h => h !== task)
    this.taskService
      .deleteTask(task.id.toString())
      .subscribe(()=> console.log('Task Deleted'))
  }

  edit(task) {
    this.editTask = task
  }

  update(){
    if(this.editTask){
      this.taskService.updateTask(this.editTask).subscribe(() =>{
        this.getTasks()
      });
      this.editTask = undefined
    }
  }

  changeStatus(task: Task): void{
    task.completed = !task.completed;
    this.editTask = task;
    this.update();
  }
}
