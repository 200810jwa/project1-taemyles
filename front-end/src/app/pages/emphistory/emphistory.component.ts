import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-emphistory',
  templateUrl: './emphistory.component.html',
  styleUrls: ['./emphistory.component.css']
})
export class EmphistoryComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goback(): void {
    this.router.navigateByUrl("/employee");
  }
}
