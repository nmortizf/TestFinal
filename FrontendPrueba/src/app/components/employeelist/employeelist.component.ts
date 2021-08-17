import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit {

  constructor(private route:ActivatedRoute, private service:DataService) { }

  listEmployees:any;

  ngOnInit(): void {

    this.service.getEmployees().subscribe((res: any)=>{
      this.listEmployees = res;
    })

  }

}
