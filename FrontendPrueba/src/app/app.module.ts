import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EmployeeidComponent } from './components/employeeid/employeeid.component';

import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { DataService } from './services/data.service';
import { AppRouterModule } from './routing.module';
import { EmployeeobjectComponent } from './components/employeeobject/employeeobject.component';
import { EmployeelistComponent } from './components/employeelist/employeelist.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeidComponent,
    EmployeeobjectComponent,
    EmployeelistComponent
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    HttpModule,
    FormsModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
