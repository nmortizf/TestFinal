import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { map }  from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  url:string = "http://localhost:8080";

  constructor(private _http:Http) { }

  public getEmployee(id:Number):any{
      return this._http.get(this.url + "/employee/" + id).pipe(map(
        response => {
          return response.json();
        },
        (error:any) =>{
          console.error(error);
        }
      ))
  }

  public getEmployees():any{
    return this._http.get(this.url + "/employees").pipe(map(
      response => {
        return response.json();
      },
      (error:any) =>{
        console.error(error);
      }
    ))
}


}
