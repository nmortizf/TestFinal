import {NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeidComponent } from './components/employeeid/employeeid.component';
import { EmployeelistComponent } from './components/employeelist/employeelist.component';
import { EmployeeobjectComponent } from './components/employeeobject/employeeobject.component';

const routes:Routes = [

    {
        path:'', redirectTo:'', pathMatch:'full'
    },
    {
        path:'employeeid',
        component: EmployeeidComponent
    },
    {
        path: 'employeeObject/:id',
        component: EmployeeobjectComponent 
    },
    {
        path: 'employeelist',
        component: EmployeelistComponent
    }

];

@NgModule(
    {
        imports: [RouterModule.forRoot(routes)],
        exports:[RouterModule
        ]
    }
)

export class AppRouterModule {}