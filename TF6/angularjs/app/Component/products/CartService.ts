import { Injectable } from '@angular/core';
import { Product } from './Product';
import { Headers, Http } from '@angular/http';
import { HomeService } from './homeService';
import { MainComponent } from './main.component';
import { Status } from './status';

@Injectable()
export class CartService {

    static products : Product[] = [];
     // URL to web api
     private headers = new Headers({'Content-Type': 'application/json'});
     private productsUrl:string;
    

    constructor(private http : Http , private homeService : HomeService){}

   
    
    getCartProducts() : Promise<Product[]>{
        let userId = this.homeService.getLoggedInUserId();
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/user/getCart'
        const url = `${this.productsUrl}/${userId}`;
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as Product[])
        .catch(this.handleError);
        
    }

    deleteFromCart(productId:number):Promise<void>{
        let userId = this.homeService.getLoggedInUserId();
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/user/deleteFromCart'
        const url=`${this.productsUrl}/${productId}/${userId}`
        return this.http.delete(url, {headers: this.headers})
        .toPromise()
        .then(() => null)
        .catch(this.handleError);
    }

    addProductToCart(product : Product): Promise<Status>{
        let userId = this.homeService.getLoggedInUserId();
        CartService.products.push(product);
        console.log(CartService.products);
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/user/add'
        return this.http
        .post(this.productsUrl, JSON.stringify({userId:userId,productId:product.id}), {headers: this.headers})
        .toPromise()
        .then(res => res.json() as Status)
        .catch(this.handleError);   
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}