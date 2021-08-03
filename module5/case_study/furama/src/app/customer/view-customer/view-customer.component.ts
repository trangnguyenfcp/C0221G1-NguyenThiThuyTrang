import {Component, Inject, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  customerId;
  customerName;
  customer;
  constructor( private customerService: CustomerService,
               public dialogRef: MatDialogRef<ViewCustomerComponent>,
               @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    this.customerId = this.data.data1.id;
    this.customerName = this.data.data1.name;
    this.customer = this.data.data1;
  }

}
