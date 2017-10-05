


import { Component, OnInit } from '@angular/core';

import { Product } from './Product';
import { ProductService } from './product-service';

@Component({
  selector: 'my-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: [ './dashboard.component.css' ],
  
})
export class DashboardComponent implements OnInit {

  products: Product[] = [];
  
    constructor(private productService: ProductService) { }
  
    ngOnInit(): void {
      this.productService.getProducts() .then(products => this.products = products.slice(1, 5));
       
    }
 }