import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {EmployeeService} from '../../service/employee.service';
import {DeleteEmployeeComponent} from '../delete-employee/delete-employee.component';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  name = '';
  startDate = '';
  endDate = '';
  page = 1;
  employees;
  constructor(private employeeService: EmployeeService,
              private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.employeeService.getAll().subscribe(employees => {
      this.employees = employees;
    });
  }
  search() {
    this.employeeService.findByName(this.name, this.startDate, this.endDate).subscribe(employees => {
      this.employees = employees;
    });
  }
  deleteDialog(id): void {
    this.employeeService.getById(id).subscribe(dataEmployee => {
      const dialogRef = this.dialog.open(DeleteEmployeeComponent, {
        width: '500px',
        data: {data1: dataEmployee}
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

}
