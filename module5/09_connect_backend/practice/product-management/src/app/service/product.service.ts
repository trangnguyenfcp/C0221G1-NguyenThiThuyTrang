import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // tslint:disable-next-line:variable-name
  public  api_url = ' http://localhost:3000/product';
  products: Product[];
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.api_url);
  }
  saveProduct(product): Observable<any> {
    return this.http.post(this.api_url, product);
  }

  findById(id: number): Observable<any> {
    return this.http.get(`${this.api_url}/${id}`);
  }

  updateProduct(id: number, product: Product): Observable<any> {
    return this.http.put(`${this.api_url}/${id}`, product);
  }
  deleteProduct(id: number) {
    return this.http.delete(`${this.api_url}/${id}`);
  }
}
