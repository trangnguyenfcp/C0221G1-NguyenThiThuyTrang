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
import {ErrorComponent} from './error/error.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListCustomerComponent,
    CreateCustomerComponent,
    DeleteCustomerComponent,
    EditCustomerComponent,
    ErrorComponent
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
