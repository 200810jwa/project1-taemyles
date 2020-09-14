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
  public receipt = null;
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
  
  fileChange(event) {
    const comp = this;
    const img = event.target.files[0] as File; // We get object with data like, name, lastModified, lastModifiedDate, size and type
    const promise = new Promise((resolve) => {
      let fileReader = new FileReader();
      fileReader.readAsArrayBuffer(img);
      fileReader.onload = function(ev) {

      const arr = new Uint8Array(fileReader.result as ArrayBuffer);
      const fileByteArray = [];
        for (let i = 0; i < arr.length; i++) {
          fileByteArray.push(arr[i]);
        }
      resolve(arr);
      } 
    });
    promise.then(img => {
      comp.receipt = img;
    });
  }

  async sendForm(): Promise<void> {
    var strReceipt = this.receipt.toString();
    console.log(strReceipt);
    try {
      // This gets the user object
      let reimburse = await this.http.post<Reimbursement>('http://ec2-18-206-232-8.compute-1.amazonaws.com:8085/ReimburseWiz/reimburseform', {
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
}