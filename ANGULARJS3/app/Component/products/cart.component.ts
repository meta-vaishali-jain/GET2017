import { Component,OnInit } from '@angular/core';
import { CartService } from './CartService';
import { Product } from './product';

@Component({
    selector:'cart',
    templateUrl : './cart.component.html'
})

export class CartComponent implements OnInit{

    products: Product[];
    constructor(private cartServices : CartService){}
    
    ngOnInit() {
        this.getCartProduct();
    }
    
    getCartProduct() : void{
        this.cartServices.getCartProducts().then(products => this.products=products);
    }
}