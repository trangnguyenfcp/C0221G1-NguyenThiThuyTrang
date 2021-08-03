import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private API_EMPLOYEE = '  http://localhost:3000/employees';
  public API_POSITION = '  http://localhost:3000/positions';
  public API_DIVISION = '  http://localhost:3000/divisions';
  public API_EDU = '  http://localhost:3000/education-degrees';
  constructor(private http: HttpClient) { }
  getAll(): Observable<any> {
    return this.http.get(this.API_EMPLOYEE);
  }
  saveEmployee(employee: any): Observable<any> {
    return this.http.post(this.API_EMPLOYEE, employee);
  }
  updateEmployee(id: number, employee: any): Observable<any> {
    return this.http.put(`${this.API_EMPLOYEE}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.API_EMPLOYEE}/${id}`);
  }
  findByName(name, startDate, endDate): Observable<any> {
    return this.http.get(`${this.API_EMPLOYEE}?name_like=${name}&birthday_gte=${startDate}&birthday_lte=${endDate}`);
  }
  getById(id: number): Observable<any> {
    return this.http.get(`${this.API_EMPLOYEE}/${id}`);
  }
  getAllPositions(): Observable<any> {
    return this.http.get(this.API_POSITION);
  }
  getAllDivisions(): Observable<any> {
    return this.http.get(this.API_DIVISION);
  }
  getAllEdu(): Observable<any> {
    return this.http.get(this.API_EDU);
  }
}
