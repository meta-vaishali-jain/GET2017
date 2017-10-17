import { Component } from "@angular/core";
import { OrderService } from "./orderService";
import { ActivatedRoute, Router, ParamMap } from "@angular/router";
import { ViewOrderDetails } from "./viewOrderDetails";
import { Location }  from '@angular/common';

@Component({
    selector: 'order-detail',
    templateUrl: `./view-order-detail.component.html`,
  })
  export class ViewOrderDetailComponent {
    viewOrderDetails: ViewOrderDetails[];

    constructor(
        private orderService: OrderService,
        private route: ActivatedRoute,
        private location: Location,
        private rt:Router
      ) {}

    ngOnInit(){
        this.route.paramMap
        .switchMap((params: ParamMap) => this.orderService.getOrderDetails(+params.get('orderId')))
        .subscribe(viewOrderDetails => this.viewOrderDetails = viewOrderDetails);
    }

    goBack(): void {
      this.location.back();
    }
  

  }