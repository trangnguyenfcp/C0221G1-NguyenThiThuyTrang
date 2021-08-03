import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {EmployeeService} from '../../service/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  maxDate = new Date();
  minDate = new Date(1900, 0, 1);
  createForm: FormGroup;
  positions;
  divisions;
  edu;
  constructor(private formBuilder: FormBuilder,
              private employeeService: EmployeeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
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
    this.getDivisions();
    this.getPositions();
    this.getEdu();
  }

  submit() {
    this.employeeService.saveEmployee(this.createForm.value).subscribe(() => {
      this.router.navigateByUrl('employee');
      this.createForm.reset();
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

}
