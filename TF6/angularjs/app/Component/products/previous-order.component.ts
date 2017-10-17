import { Component } from "@angular/core";
import { OrderService } from "./orderService";
import { OrderDetails } from "./OrderDetails";
import { Location }  from '@angular/common';

@Component({
    selector: 'my-orders',
    templateUrl: `./previous-order.component.html`,
    
  })

  export class OrderComponent {

    orderDetails: OrderDetails[];

    constructor(
     
      
      private orderService : OrderService,
      private location: Location) { }

        ngOnInit(){
          this.orderService.getAllOrders(+localStorage.getItem('userId')).then(orderDetails => this.orderDetails=orderDetails);;
        }

        goBack(): void {
          this.location.back();
        }
      
  }