import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private API_CUSTOMERS = '  http://localhost:3000/customers';
  public API_CUSTOMER_TYPES = '  http://localhost:3000/customer-types';
  constructor(private http: HttpClient) { }
  getAll(): Observable<any> {
    return this.http.get(this.API_CUSTOMERS);
  }
  saveCustomer(customer: any): Observable<any> {
    return this.http.post(this.API_CUSTOMERS, customer);
  }
  updateCustomer(id: number, customer: any): Observable<any> {
    return this.http.put(`${this.API_CUSTOMERS}/${id}`, customer);
  }

  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.API_CUSTOMERS}/${id}`);
  }
  // findByName(name: string, startDate: string, endDate: string): Observable<any> {
  //   return this.http.get(`${this.API}?name_like=${name}&birthday_gte=${startDate}&birthday_lte=${endDate}`);
  // }
  findByName(name: string): Observable<any> {
    return this.http.get(`${this.API_CUSTOMERS}?name_like=${name}`);
  }
  getById(id: number): Observable<any> {
    return this.http.get(`${this.API_CUSTOMERS}/${id}`);
  }
  getAllCustomerTypes(): Observable<any> {
    return this.http.get(this.API_CUSTOMER_TYPES);
  }
}
