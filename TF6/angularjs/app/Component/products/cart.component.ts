import { Component,OnInit } from '@angular/core';
import { CartService } from './CartService';
import { Product } from './product';
import { MainComponent } from './main.component';
import { Location }  from '@angular/common';

@Component({
    selector:'cart',
    templateUrl : './cart.component.html'
})

export class CartComponent implements OnInit{

    products: Product[];
    constructor(private cartServices : CartService,
        private location: Location,
        private mainComponent:MainComponent){}
    
    ngOnInit() {
        this.getCartProduct();
    }
    
    getCartProduct() : void{
        this.cartServices.getCartProducts().then(products => this.products=products);
    }

    deleteFromCart(product: Product) {
        

        this.cartServices.deleteFromCart(product.id).then(() => {
            let index = this.products.indexOf(product);
            this.products.splice(index, 1);
           this.mainComponent.ngOnInit();
        });
    }

    goBack(): void {
        this.location.back();
      }
    
}
