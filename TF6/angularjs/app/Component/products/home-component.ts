import { Component } from '@angular/core';
import {Product} from './Product';
import { ProductService } from './product-service';
import { HomeService } from './homeService';
import { MiniCart } from './userMiniCartDetail';
import { Router } from '@angular/router';

@Component({
    selector: 'my-home',
    templateUrl: './homeComponent.html',
    styleUrls: [ './homeComponent.css' ],
})
export class HomeComponent {
 title = 'Shopping Cart';
 products: Product[] = [];
  minicart:MiniCart;
 constructor(
    private productService: ProductService , private homeService : HomeService,
    private router:Router) { 
        
    }

    getProducts(): void {
        this.productService.getProducts().then(products=>{this.products=products;  });
      }

      getMiniCart():MiniCart{
        return this.minicart;
      }
 
      ngOnInit(): void {
        this.getProducts();
      }

      login(userName:string):void{

        if(userName.length!==0)
        {
          this.homeService.saveUser(userName);
        
         this.homeService.login(userName).then(response =>
          {
            
            if(response.totalPrice<0){
              alert("User not exist");
            }
            else{

           localStorage.setItem('userId', response.user.userId.toString() );   
            this.router.navigate(['main/dashboard']);
            
          }
        })
      }else{
        alert("Please  enter name")
      }
    
      }
    }


