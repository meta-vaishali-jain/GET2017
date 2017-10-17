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
var http_1 = require("@angular/http");
var CheckoutService = (function () {
    function CheckoutService(http) {
        this.http = http;
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
    }
    CheckoutService.prototype.savePaymentDetails = function (orderDetails) {
        console.log(JSON.stringify(orderDetails));
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/user/savePaymentDetails';
        return this.http
            .put(this.productsUrl, JSON.stringify(orderDetails), { headers: this.headers })
            .toPromise()
            .then(function (response) { return response.json(); });
    };
    return CheckoutService;
}());
CheckoutService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], CheckoutService);
exports.CheckoutService = CheckoutService;
//# sourceMappingURL=checkoutService.js.map