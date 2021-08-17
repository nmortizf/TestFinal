import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employeeid',
  templateUrl: './employeeid.component.html',
  styleUrls: ['./employeeid.component.css']
})
export class EmployeeidComponent implements OnInit {

  idEmployee!: number;

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  onSelect(id:number){
    this.router.navigate(['/employeeObject',id]);
  }

  showAll(){
    this.router.navigate(['employeelist']);
  }

}
