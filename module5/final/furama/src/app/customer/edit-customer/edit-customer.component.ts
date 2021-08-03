import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  maxDate = new Date();
  minDate = new Date(1900, 0, 1);
  editForm: FormGroup;
  customerId;
  customerTypes;
  selectedCustomerType;
  constructor(private formBuilder: FormBuilder,
              private customerService: CustomerService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group({
      id: [''],
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
    this.activatedRoute.params.subscribe(data => {
        this.customerId = data.id;
        this.customerService.getById(this.customerId).subscribe(data2 => {
          this.editForm.patchValue(data2);
        });
    });
    this.getCustomerTypes();
  }
  submit() {
    const customer = this.editForm.value;
    this.customerService.updateCustomer(this.customerId, customer).subscribe(() => {
      this.router.navigateByUrl('customer');
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
  compare(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
