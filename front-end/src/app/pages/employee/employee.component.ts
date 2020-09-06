import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  public currentUser: User = undefined;
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));
  }

  formpage(): void {
    this.router.navigateByUrl("/empform");
  }
  
  historypage(): void {
    this.router.navigateByUrl("/emphistory");
  }
  
  logout(): void {
    sessionStorage.removeItem("currentUser");
    this.router.navigateByUrl("/home");
  }
}