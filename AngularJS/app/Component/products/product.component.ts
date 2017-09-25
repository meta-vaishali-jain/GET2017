import { Component } from '@angular/core';
import { ProductService } from './product-service';

export class Product {
  id: number;
  name: string;
  price:number;
}




@Component({
    selector: 'my-app',
    templateUrl: `./product.component.html`,
    
  })

  export class ProductComponent {
    title = 'Product Details';
    products: Product[];
    selectedProduct: Product;

    constructor(private productService: ProductService) { }
    
     getProducts(): void {
       this.products=this.productService.getProducts();
     }
    
     ngOnInit(): void {
       this.getProducts();
     }
    
     onSelect(product: Product): void {
       this.selectedProduct = product;
     }
}