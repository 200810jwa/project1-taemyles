import { HttpClient } from '@angular/common/http';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public fName: string = "";
  public lName: string = "";
  public username: string = "";
  public password: string = "";
  public vPassword: string = "";
  public email: string = "";
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
  }

  async sendRegister(): Promise<void> {
    try {
      // This gets the user object
      let user = await this.http.post<User>('http://localhost:8080/ReimburseWiz/register', {
          fName: this.fName,
          lName: this.lName,
          username: this.username,
          password: this.password,
          vPassword: this.vPassword,
          email: this.email
        }, {
        withCredentials: true // cookie
      }).toPromise();

      sessionStorage.setItem("currentUser", JSON.stringify(user));
    } catch(error) {
      // Failed to login
      // console.log(error);
      alert("Failed to Register");
    }
  }
}
