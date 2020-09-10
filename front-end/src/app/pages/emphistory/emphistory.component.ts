import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { RStatus, RType, Reimbursement } from 'src/app/models/reimbursement';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-emphistory',
  templateUrl: './emphistory.component.html',
  styleUrls: ['./emphistory.component.css']
})
export class EmphistoryComponent implements OnInit {
  public reimbursement: Reimbursement[] = [];
  public id: number = undefined;
  public amount: number = undefined;
  public timeSubmitted: Date = undefined;
  public timeResolved: Date = undefined;
  public description: string = "";
  public receipt: any;
  public author: User = undefined;
  public resolver: User = undefined;
  public status: RStatus = undefined;
  public type: RType = undefined;
  public currentUser: User = undefined;
  public image: any;

  constructor(private router: Router, private http: HttpClient, private DomSanitizer: DomSanitizer) { }
  
  async ngOnInit(): Promise<void> {
    // const reader = new FileReader();
    // reader.onload = (e) => this.image = e.target.result;
    // reader.readAsDataURL(new Blob([this.receipt]));
    try {
      // This gets the user object
      let reimburse = await this.http.post<Reimbursement[]>('http://localhost:8080/ReimburseWiz/reimburseInfo', {
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
      var base64String = btoa(String.fromCharCode.apply(null, new Uint8Array(this.receipt)));
      console.log(base64String);
      this.image = 'data:image/jpeg;base64,' + base64String;
      console.log(this.reimbursement);
    } catch(error) {
      alert("Failed to retreive reimbursement info");
    }
  }

  goback(): void {
    this.router.navigateByUrl("/employee");
  }
}
