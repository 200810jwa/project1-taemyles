import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {
  public currentUser: User = undefined;
  constructor(private router: Router) { }
  
  ngOnInit(): void {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));
  }

  logout(): void {
    sessionStorage.removeItem("currentUser");
    this.router.navigateByUrl("/home");
  }
}