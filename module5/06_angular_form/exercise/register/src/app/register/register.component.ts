import {Component, OnInit} from '@angular/core';
import {AbstractControl, NgForm} from '@angular/forms';
import {FormControl, FormGroup, Validators} from '@angular/forms';

import {User} from '../user';
function comparePassword(abstractControl: AbstractControl) {
  const confirm = abstractControl.value;
  return (confirm.password === confirm.confirmPassword) ?
    null : {
      notMatch: true
    };
}
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  countries = ['Vietnam', 'Laos', 'Campuchia'];
  constructor() {
    this.registerForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      passwordForm: new FormGroup({
        password: new FormControl('', [Validators.required, Validators.minLength(6)]),
        confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
      }, comparePassword),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]),
    });
  }

  ngOnInit(): void {
  }
  onSubmit() {
    console.log(this.registerForm.value);
  }
}
