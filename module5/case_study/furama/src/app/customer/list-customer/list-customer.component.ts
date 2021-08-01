import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../server/customer.service';
import {FormsModule} from '@angular/forms';
import {MatDialog} from '@angular/material/dialog';
import {DeleteCustomerComponent} from '../delete-customer/delete-customer.component';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  name = '';
  startDate = '';
  endDate = '';
  page = 1;
  customers;
  constructor(private customerService: CustomerService,
              private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.customerService.getAll().subscribe(customers => {
      this.customers = customers;
    });
  }
  search() {
      this.customerService.findByName(this.name, this.startDate, this.endDate).subscribe(customers => {
        console.log(customers);
        this.customers = customers;
      });
  }
  deleteDialog(id): void {
    this.customerService.getById(id).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(DeleteCustomerComponent, {
        width: '500px',
        data: {data1: dataCustomer}
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
