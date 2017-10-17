import { Injectable } from "@angular/core";
import { OrderDetails } from "./OrderDetails";

import { Headers, Http } from '@angular/http';

@Injectable()
export class CheckoutService {
    productsUrl : string;
    private headers = new Headers({'Content-Type': 'application/json'});

    constructor(private http: Http) { }
    savePaymentDetails( orderDetails:OrderDetails):Promise<OrderDetails>{
        console.log(JSON.stringify(orderDetails));
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/user/savePaymentDetails';
        return this.http
        .put(this.productsUrl, JSON.stringify(orderDetails), {headers: this.headers})
        .toPromise()
        .then(response => response.json());
    }
}