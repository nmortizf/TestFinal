import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-employeeobject',
  templateUrl: './employeeobject.component.html',
  styleUrls: ['./employeeobject.component.css']
})
export class EmployeeobjectComponent implements OnInit {

  data:any;

  constructor(private route:ActivatedRoute, private service:DataService) { }

  ngOnInit(): void {
   var id2 = (this.route.snapshot.paramMap.get("id"));
    if(id2 != null){
      var id = Number.parseInt(id2);
      this.service.getEmployee(id).subscribe((res: any)=>{
        this.data = res;
      }) 
    }     
  }

}
