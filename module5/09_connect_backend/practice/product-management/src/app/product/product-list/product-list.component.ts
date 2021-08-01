import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor(private productService: ProductService) { }
  products: Product[] = [];
  ngOnInit() {
    this.getAll();
  }
  getAll() {
     this.productService.getAll().subscribe(next => {
       this.products = next;
       alert('success');
     }, error => {
       alert('Error');
     }, () => {
      alert('complete');
     });
  }
}
