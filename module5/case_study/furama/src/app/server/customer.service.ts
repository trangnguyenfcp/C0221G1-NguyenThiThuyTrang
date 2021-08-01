import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API = '  http://localhost:3000/customers';
  public API_CUSTOMER_TYPES = '  http://localhost:3000/customer-types';
  constructor(private http: HttpClient) { }
  getAll(): Observable<any> {
    return this.http.get(this.API);
  }
  saveCustomer(customer: any): Observable<any> {
    return this.http.post(this.API, customer);
  }
  updateCustomer(id: number, customer: any): Observable<any> {
    return this.http.put(`${this.API}/${id}`, customer);
  }

  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.API}/${id}`);
  }
  findByName(name, startDate, endDate): Observable<any> {
    return this.http.get(`${this.API}?name_like=${name}&birthday_gte=${startDate}&birthday_lte=${endDate}`);
  }
  getById(id: number): Observable<any> {
    return this.http.get(`${this.API}/${id}`);
  }
  getAllCustomerTypes(): Observable<any> {
    return this.http.get(this.API_CUSTOMER_TYPES);
  }
}
