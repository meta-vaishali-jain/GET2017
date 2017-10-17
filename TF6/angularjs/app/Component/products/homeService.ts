import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { MiniCart } from './userMiniCartDetail';

@Injectable()
export class HomeService {
    private headers = new Headers({'Content-Type': 'application/json'});
    private productsUrl:string;
    constructor(private http: Http) { }
    minicart: MiniCart;
    login(userName:string):Promise<MiniCart>{
      this.productsUrl="http://localhost:8080/shoppinghibernate/rest/user/get";
      const url = `${this.productsUrl}/${userName}`;
      return this.http.get(url)
      .toPromise()
      .then(response => this.minicart = response.json() as MiniCart)
      .catch(this.handleError);
    }

    getLoggedInUser() :string{
      let userName = localStorage.getItem('userName');
      console.log(userName);
      return userName;
      }

      getLoggedInUserId() : number {
        let userId = localStorage.getItem('userId');
        return +userId;
        }

       private handleError(error: any): Promise<any> {
       console.error('An error occurred', error); // for demo purposes only
       return Promise.reject(error.message || error);
     }

     saveUser(userName: string) {
      localStorage.setItem('userName',userName);
      }
}