import { Injectable } from '@angular/core';

import { Product } from './product.component';
import { PRODUCTS } from './mock-products';


@Injectable()
export class ProductService {
    getProducts(): Product[] {
        return PRODUCTS;
    } // stub
}