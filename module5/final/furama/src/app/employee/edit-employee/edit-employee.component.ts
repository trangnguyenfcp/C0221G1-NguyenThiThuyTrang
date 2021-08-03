import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeeService} from '../../service/employee.service';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  employeeId;
  maxDate = new Date();
  minDate = new Date(1900, 0, 1);
  editForm: FormGroup;
  positions;
  divisions;
  edu;
  selectedPosition;
  selectedDivision;
  selectedEdu;
  constructor(private formBuilder: FormBuilder,
              private employeeService: EmployeeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group({
      id: [''],
      name: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern('^([\\d]{9}|[\\d]{12})$')]],
      position: ['', [Validators.required]],
      division: ['', [Validators.required]],
      educationDegree: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      birthday: ['', [Validators.required, this.validateBirthday]],
      phone: ['', [Validators.required, Validators.pattern('^(\\(84\\)\\+|0)9[0|1][\\d]{7}$')]],
      address: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      salary: ['', [Validators.required, Validators.min(0)]]
    });
    this.activatedRoute.params.subscribe(data => {
      this.employeeId = data.id;
      this.employeeService.getById(this.employeeId).subscribe(data2 => {
        this.editForm.patchValue(data2);
      });
    });
    this.getDivisions();
    this.getEdu();
    this.getPositions();
    console.log(this.selectedPosition);
  }
  submit() {
    const employee = this.editForm.value;
    this.employeeService.updateEmployee(this.employeeId, employee).subscribe(() => {
      this.router.navigateByUrl('employee');
    });
  }

  validateBirthday(control: AbstractControl) {
    const date = control.value;
    const today = new Date();
    const birthDate = new Date(date);
    let age = today.getFullYear() - birthDate.getFullYear();
    const month = today.getMonth() - birthDate.getMonth();
    if (month < 0 || (month === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    if (age < 18) {
      return {'validateBirthday': true};
    } else {
      return null;
    }
  }
  getPositions() {
    this.employeeService.getAllPositions().subscribe(positions => {
      this.positions = positions;
    });
  }
  getDivisions() {
    this.employeeService.getAllDivisions().subscribe(divisions => {
      this.divisions = divisions;
    });
  }
  getEdu() {
    this.employeeService.getAllEdu().subscribe(edu => {
      this.edu = edu;
    });
  }
  compare(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
