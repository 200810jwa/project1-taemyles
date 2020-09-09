
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';

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
      // This gets the user object
      let user = await this.http.post<User>('http://localhost:8080/ReimburseWiz/login', {
          username: this.username,
          password: this.password,
        }, {
        withCredentials: true // cookie
      }).toPromise();

      sessionStorage.setItem("currentUser", JSON.stringify(user));
      if (user.role.id == 1) {
        this.router.navigateByUrl("/manager");
      }
      
      else {
        this.router.navigateByUrl("/employee");
      }
  
    } catch(error) {
      // Failed to login
      // console.log(error);
      alert("Failed to login");
    }
  }
}