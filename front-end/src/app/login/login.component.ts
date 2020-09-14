
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
  public show: boolean = false;
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
  }

  wait(ms){
    var start = new Date().getTime();
    var end = start;
    while(end < start + ms) {
      end = new Date().getTime();
   }
 }
  async sendLogin(): Promise<void> {
    try {
      // This gets the user object
      let user = await this.http.post<User>('http://ec2-18-206-232-8.compute-1.amazonaws.com:8085/ReimburseWiz/login', {
          username: this.username,
          password: this.password,
        }, {
        withCredentials: true // cookie
      }).toPromise();
      sessionStorage.setItem("currentUser", JSON.stringify(user));
      this.wait(1000);
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
  
  delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
  }
  dispAlert() {
    this.show = true;
  }

  registerPage(): void {
    this.router.navigateByUrl("/register");
  }
}