"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var orderService_1 = require("./orderService");
var router_1 = require("@angular/router");
var common_1 = require("@angular/common");
var ViewOrderDetailComponent = (function () {
    function ViewOrderDetailComponent(orderService, route, location, rt) {
        this.orderService = orderService;
        this.route = route;
        this.location = location;
        this.rt = rt;
    }
    ViewOrderDetailComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.paramMap
            .switchMap(function (params) { return _this.orderService.getOrderDetails(+params.get('orderId')); })
            .subscribe(function (viewOrderDetails) { return _this.viewOrderDetails = viewOrderDetails; });
    };
    ViewOrderDetailComponent.prototype.goBack = function () {
        this.location.back();
    };
    return ViewOrderDetailComponent;
}());
ViewOrderDetailComponent = __decorate([
    core_1.Component({
        selector: 'order-detail',
        templateUrl: "./view-order-detail.component.html",
    }),
    __metadata("design:paramtypes", [orderService_1.OrderService,
        router_1.ActivatedRoute,
        common_1.Location,
        router_1.Router])
], ViewOrderDetailComponent);
exports.ViewOrderDetailComponent = ViewOrderDetailComponent;
//# sourceMappingURL=view-order-detail.component.js.map