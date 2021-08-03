import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "../../../furama-resort/src/app/home/home.component";
import {ListCustomerComponent} from "./customer/list-customer/list-customer.component";
import {CreateCustomerComponent} from './customer/create-customer/create-customer.component';
import {EditCustomerComponent} from './customer/edit-customer/edit-customer.component';
import {ListEmployeeComponent} from './employee/list-employee/list-employee.component';
import {CreateEmployeeComponent} from './employee/create-employee/create-employee.component';
import {EditEmployeeComponent} from './employee/edit-employee/edit-employee.component';
import {ErrorComponent} from './error/error.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customer', component: ListCustomerComponent},
  {path: 'customer/create', component: CreateCustomerComponent},
  {path: 'customer/edit/:id', component: EditCustomerComponent},
  {path: 'employee', component: ListEmployeeComponent},
  {path: 'employee/create', component: CreateEmployeeComponent},
  {path: 'employee/edit/:id', component: EditEmployeeComponent},
  {path: '**', component: ErrorComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
