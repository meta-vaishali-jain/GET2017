import { Injectable } from '@angular/core';

import { Product } from './Product';
import { PRODUCTS } from './mock-products';


import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';



@Injectable()
export class ProductService {
    private productsUrl = 'http://localhost:8080/layered-arch/service/product/list';  // URL to web api
    private headers = new Headers({'Content-Type': 'application/json'});
    
   constructor(private http: Http) { }
    getProducts(): Promise<Product[]> {
        return this.http.get(this.productsUrl)
        .toPromise()
        .then(response => response.json() as Product[])
        .catch(this.handleError);
    } // stub

    getProduct(id: number): Promise<Product> {
        const url = `${this.productsUrl}/${id}`;
        return this.http.get(url)
        .toPromise()
        .then(response => response.json().data as Product)
        .catch(this.handleError);
      }

      update(product: Product): Promise<Product> {
        const url = `${this.productsUrl}/${product.id}`;
        return this.http
          .put(url, JSON.stringify(product), {headers: this.headers})
          .toPromise()
          .then(() => product)
          .catch(this.handleError);
      }

      create(name: string , price: string,img_url:string): Promise<Product> {

        return this.http
          .post(this.productsUrl, JSON.stringify({name: name,price:price,img_url:img_url}), {headers: this.headers})
          .toPromise()
          .then(res => res.json().data as Product)
          .catch(this.handleError);
      }

      delete(id: number): Promise<void> {
        const url = `${this.productsUrl}/${id}`;
        return this.http.delete(url, {headers: this.headers})
          .toPromise()
          .then(() => null)
          .catch(this.handleError);
      }

     private handleError(error: any): Promise<any> {
       console.error('An error occurred', error); // for demo purposes only
       return Promise.reject(error.message || error);
     }


}


