import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';
import { User } from 'src/app/models/user';
import { RStatus, RType, Reimbursement } from 'src/app/models/reimbursement';

@Component({
  selector: 'app-managercontrolpanel',
  templateUrl: './managercontrolpanel.component.html',
  styleUrls: ['./managercontrolpanel.component.css']
})

export class ManagercontrolpanelComponent implements OnInit {
  public reimbursement: Reimbursement[] = [];
  public id: number = undefined;
  public amount: number = undefined;
  public timeSubmitted: Date = undefined;
  public timeResolved: Date = undefined;
  public description: string = "";
  public receipt: string = "";
  public author: User = undefined;
  public resolver: User = undefined;
  public status: RStatus = undefined;
  public type: RType = undefined;
  public currentUser: User = undefined;
  public image: any;
  public statusFilter: any;

  filterStatus(statusFilter: RStatus) {
    if (statusFilter.name == "pending") {
      return statusFilter.name == "pending";
    } else if (statusFilter.name == "approved") {
      return statusFilter.name == "approved";
    } else {
      return statusFilter.name =="denied";
    }

  }

  constructor(private router: Router, private http: HttpClient, private domSanitizer: DomSanitizer) { }


  async ngOnInit(): Promise<void> {
    try {
     // This gets the user object
      let reimburse = await this.http.post<Reimbursement[]>('http://localhost:8080/ReimburseWiz/managerReimbursement', {
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
     this.reimbursement = reimburse;
    } catch(error) {
     alert("Failed to retreive reimbursement info");
   }
 }
 async sendApproval(): Promise<void> {
  var strReceipt = this.receipt.toString();
  console.log(strReceipt);
  try {
    // This gets the user object
    let reimburse = await this.http.post<Reimbursement>('http://localhost:8080/ReimburseWiz/managerapproval', {
      id: this.id,
      amount: this.amount,
      timeSubmitted: this.timeSubmitted,
      timeResolved: this.timeResolved,
      description: this.description,
      receipt: strReceipt,
      author: this.author,
      resolver: this.resolver,
      status: this.status,
      type: this.type
      }, {
      withCredentials: true // cookie
    }).toPromise();
    console.log(reimburse);
    sessionStorage.setItem("reimbursement", JSON.stringify(reimburse));
    this.goback();
  } catch(error) {
    alert("Failed to submit the form");
  }
}

  goback(): void {
    this.router.navigateByUrl("/manager");
  }
}
