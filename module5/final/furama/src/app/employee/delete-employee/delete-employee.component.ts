import {Component, Inject, OnInit} from '@angular/core';
import {EmployeeService} from '../../service/employee.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {

  employeeName;
  employeeId;
  constructor(
    private employeeService: EmployeeService,
    public dialogRef: MatDialogRef<DeleteEmployeeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.employeeName = this.data.data1.name;
    this.employeeId = this.data.data1.id;
  }
  delete() {
    this.employeeService.deleteEmployee(this.employeeId).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
