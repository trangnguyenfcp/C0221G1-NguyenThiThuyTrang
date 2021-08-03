import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import {HttpClientModule} from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import { CreateCustomerComponent } from './customer/create-customer/create-customer.component';
import {MaterialModule} from './material.module';
import {DeleteCustomerComponent} from './customer/delete-customer/delete-customer.component';
import {EditCustomerComponent} from './customer/edit-customer/edit-customer.component';
import {ListEmployeeComponent} from './employee/list-employee/list-employee.component';
import {CreateEmployeeComponent} from './employee/create-employee/create-employee.component';
import {DeleteEmployeeComponent} from './employee/delete-employee/delete-employee.component';
import {EditEmployeeComponent} from './employee/edit-employee/edit-employee.component';
import {ErrorComponent} from './error/error.component';
import {ViewCustomerComponent} from './customer/view-customer/view-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListCustomerComponent,
    CreateCustomerComponent,
    DeleteCustomerComponent,
    EditCustomerComponent,
    ListEmployeeComponent,
    CreateEmployeeComponent,
    DeleteEmployeeComponent,
    EditEmployeeComponent,
    ErrorComponent,
    ViewCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
