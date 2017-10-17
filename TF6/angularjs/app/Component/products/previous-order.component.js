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
var common_1 = require("@angular/common");
var OrderComponent = (function () {
    function OrderComponent(orderService, location) {
        this.orderService = orderService;
        this.location = location;
    }
    OrderComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.orderService.getAllOrders(+localStorage.getItem('userId')).then(function (orderDetails) { return _this.orderDetails = orderDetails; });
        ;
    };
    OrderComponent.prototype.goBack = function () {
        this.location.back();
    };
    return OrderComponent;
}());
OrderComponent = __decorate([
    core_1.Component({
        selector: 'my-orders',
        templateUrl: "./previous-order.component.html",
    }),
    __metadata("design:paramtypes", [orderService_1.OrderService,
        common_1.Location])
], OrderComponent);
exports.OrderComponent = OrderComponent;
//# sourceMappingURL=previous-order.component.js.map