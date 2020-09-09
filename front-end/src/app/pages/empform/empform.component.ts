import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Reimbursement, RStatus, RType } from 'src/app/models/reimbursement';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-empform',
  templateUrl: './empform.component.html',
  styleUrls: ['./empform.component.css']
})
export class EmpformComponent implements OnInit {
  public id: number = undefined;
  public amount: number = undefined;
  public timeSubmitted: Date = undefined;
  public timeResolved: Date = undefined;
  public description: string = "";
  public receipt: any = undefined;
  public author: User = undefined;
  public resolver: User = undefined;
  public status: RStatus = undefined;
  public type: RType = undefined;
  public currentUser: User = undefined;

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));
  }
  
  goback(): void {
    this.router.navigateByUrl("/employee");
  }

  async sendForm(): Promise<void> {
    try {
      // This gets the user object
      let reimburse = await this.http.post<Reimbursement>('http://localhost:8080/ReimburseWiz/reimburseform', {
        id: this.id,
        amount: this.amount,
        timeSubmitted: this.timeSubmitted,
        timeResolved: this.timeResolved,
        description: this.description,
        receipt: this.receipt,
        author: this.author,
        resolver: this.resolver,
        status: this.status,
        type: this.type
  
        }, {
        withCredentials: true // cookie
      }).toPromise();
      sessionStorage.setItem("reimbursement", JSON.stringify(reimburse));

    } catch(error) {
      alert("Failed to submit the form");
    }
  }
}