import { Component, Input,OnInit } from '@angular/core';
import { MiniCart } from './userMiniCartDetail';
import { HomeService } from './homeService';
import { Router } from '@angular/router';


@Component({
selector: 'app-header',
templateUrl: './main.component.html',
styleUrls : ['./main-component.css']
})
export class MainComponent implements OnInit {
@Input() public title = "Shopping Cart";
@Input() public isUserLoggedIn: boolean;
@Input() minicart : MiniCart;

constructor(
    private homeservice : HomeService,
    private router: Router){
        this.minicart=new MiniCart();
    }

ngOnInit(){
this.homeservice.login(localStorage.getItem('userName')).then((response) => {
this.minicart = response; 
localStorage.setItem('finalPrice',this.minicart.totalPrice.toString())
});
}

LogOut(){
    localStorage.clear();
    this.router.navigate(['/home']);
} 
}