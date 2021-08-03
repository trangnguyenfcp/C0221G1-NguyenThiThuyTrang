import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {
  customerName;
  customerId;
  constructor(
    private customerService: CustomerService,
    public dialogRef: MatDialogRef<DeleteCustomerComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.customerName = this.data.data1.name;
    this.customerId = this.data.data1.id;
  }
  delete() {
this.customerService.deleteCustomer(this.customerId).subscribe(data => {
  this.dialogRef.close();
});
  }

}
