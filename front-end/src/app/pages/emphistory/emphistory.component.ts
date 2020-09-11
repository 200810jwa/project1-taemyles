import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { RStatus, RType, Reimbursement } from 'src/app/models/reimbursement';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';
import { CompileShallowModuleMetadata } from '@angular/compiler';

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
  public receipt: Uint8Array = undefined;
  public author: User = undefined;
  public resolver: User = undefined;
  public status: RStatus = undefined;
  public type: RType = undefined;
  public currentUser: User = undefined;
  public image: any;
  constructor(private router: Router, private http: HttpClient, private domSanitizer: DomSanitizer) { }
  async ngOnInit(): Promise<void> {
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
       for (var i = 0; i < this.reimbursement.length; i++) {
        console.log(this.reimbursement[i].receipt)
        
       }
    } catch(error) {
      alert("Failed to retreive reimbursement info");
    }
  }

  goback(): void {
    this.router.navigateByUrl("/employee");
  }
}
