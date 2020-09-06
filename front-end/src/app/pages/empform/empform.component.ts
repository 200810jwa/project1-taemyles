import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-empform',
  templateUrl: './empform.component.html',
  styleUrls: ['./empform.component.css']
})
export class EmpformComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  
  goback(): void {
    this.router.navigateByUrl("/employee");
  }
}
