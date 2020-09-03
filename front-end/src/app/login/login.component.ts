import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';
import {Employee} from 'src/app/models/employee';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  public username: string = "";
  public password: string = "";

  constructor(private router: Router, private http: HttpClient) { }


  ngOnInit(): void {
  }

  async sendLogin(): Promise<void> {
    try {
      let employee = await this.http.post<Employee>('http://localhost:8080/back-end/login', {
          username: this.username,
          password: this.password }, {
        withCredentials: true
        // Property that you want to have in order to leverage cookies
        // Our session will be stored as a cookie in the browser
      }).toPromise();

      sessionStorage.setItem("currentUser", JSON.stringify(employee));

      this.router.navigateByUrl("/manager");
    } catch(error) {
      // Failed to login
      // console.log(error);
      alert("Failed to login");
    }
  }
}
