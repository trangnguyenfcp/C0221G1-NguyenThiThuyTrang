import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators, AbstractControl} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  maxDate = new Date();
  minDate = new Date(1900, 0, 1);
  createForm: FormGroup;
  customerTypes;
  constructor(private formBuilder: FormBuilder,
              private customerService: CustomerService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      code: ['', [Validators.required, Validators.pattern('^KH-[\\d]{4}$')]],
      idCard: ['', [Validators.required, Validators.pattern('^([\\d]{9}|[\\d]{12})$')]],
      customerType: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      birthday: ['', [Validators.required, this.validateBirthday]],
      phone: ['', [Validators.required, Validators.pattern('^(\\(84\\)\\+|0)9[0|1][\\d]{7}$')]],
      address: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
    });
    this.getCustomerTypes();
  }

  submit() {
    this.customerService.saveCustomer(this.createForm.value).subscribe(() => {
      this.router.navigateByUrl('customer');
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
    getCustomerTypes() {
    this.customerService.getAllCustomerTypes().subscribe(customerTypes => {
      this.customerTypes = customerTypes;
    });
    }
}
