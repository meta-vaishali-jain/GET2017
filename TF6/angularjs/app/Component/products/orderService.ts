import { Injectable } from "@angular/core";
import { OrderDetails } from "./OrderDetails";
import { Http } from "@angular/http";
import { ViewOrderDetails } from "./viewOrderDetails";

@Injectable()
export class OrderService {

    private productsUrl:string;
    constructor(private http: Http) { }

    getAllOrders( userId:number): Promise<OrderDetails[]> {
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/user/getOrders'; 
        const url = `${this.productsUrl}/${userId}`;
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as OrderDetails[])
        .catch(this.handleError);
      } // stub
      private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }

    getOrderDetails(orderId:number):Promise<ViewOrderDetails[]>{
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/user/getOrderDetails';
        const url = `${this.productsUrl}/${orderId}`;
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as ViewOrderDetails[])
        .catch(this.handleError);
    }
}