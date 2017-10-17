import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { OrderDetails } from "./OrderDetails";
import {PaymentDetails} from "./PaymentDetails";
import { CheckoutService } from "./checkoutService";
import { MainComponent } from "./main.component";

@Component({
    selector: 'payment-gateway',
    templateUrl: `./payment-gateway.html`,
    styleUrls: [ './payment-gateway.css' ],
  })

  export class PaymentGatewayComponent {
        finalPrice:number;
        orderDetails:OrderDetails;
        paymentId:PaymentDetails;


    constructor(
       
        private router: Router,
        private checkoutService: CheckoutService,
       ){}

        ngOnInit(){
            this.paymentId=new PaymentDetails();
            this.orderDetails=new OrderDetails();
            this.finalPrice=+localStorage.getItem('finalPrice');
        }

        checkCardNumber(cardNumber :string){
            var cardno = /^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$/;  
            if(cardNumber.match(cardno))  
                  {  
                      
                return true;  
                  }  
                else  
                  {  
                  alert("Not a valid Amercican Express credit card number!");  
                  return false;  
                  }  
        }

        checkMonth(expiryMonth :string){
            var month = /^(0?[1-9]|1[012])$/;  
            if(expiryMonth.match(month))  
                  {  
                      
                return true;  
                  }  
                else  
                  {  
                  alert("Enter valid month");  
                  return false;  
                  }  
        }

        checkYear(expiryYear :string){
            var year = /^[0-9]{2}$/;  
            if(expiryYear.match(year))  
                  {  
                      
                return true;  
                  }  
                else  
                  {  
                  alert("Enter valid year");  
                  return false;  
                  }  
        }

        checkCvvCode(cvCode : string){
            var code = /^[0-9]{3,4}$/;  
            if(cvCode.match(code))  
                  {  
                      
                return true;  
                  }  
                else  
                  {  
                  alert("Enter valid code");  
                  return false;  
                  }  
        }

    

    savePaymentDetails(cardNumber:string,expiryMonth:number,expiryYear:number,cvCode:string):void{
        if(this.checkCardNumber(cardNumber) && this.checkMonth(expiryMonth.toString()) && this.checkYear(expiryYear.toString())&& this.checkCvvCode(cvCode)){
        this.paymentId.cardNumber=cardNumber;
        this.paymentId.expiryMonth=expiryMonth;
        this.paymentId.expiryYear=expiryYear;
        this.paymentId.userId=+localStorage.getItem('userId');
        this.orderDetails.orderDate=new Date();
        this.orderDetails.finalPrice=this.finalPrice;
        this.orderDetails.paymentId=this.paymentId;
        console.log(this.paymentId.cardNumber);
        console.log(this.orderDetails.paymentId.cardNumber);
        this.checkoutService.savePaymentDetails(this.orderDetails);
        this.mainComponent.ngOnInit();
        this.router.navigate(['main/products']);
        }else{
            
        }
    }

  }