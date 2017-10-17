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
var homeService_1 = require("./homeService");
var CartService = CartService_1 = (function () {
    function CartService(http, homeService) {
        this.http = http;
        this.homeService = homeService;
        // URL to web api
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
    }
    CartService.prototype.getCartProducts = function () {
        var userId = this.homeService.getLoggedInUserId();
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/user/getCart';
        var url = this.productsUrl + "/" + userId;
        return this.http.get(url)
            .toPromise()
            .then(function (response) { return response.json(); })
            .catch(this.handleError);
    };
    CartService.prototype.deleteFromCart = function (productId) {
        var userId = this.homeService.getLoggedInUserId();
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/user/deleteFromCart';
        var url = this.productsUrl + "/" + productId + "/" + userId;
        return this.http.delete(url, { headers: this.headers })
            .toPromise()
            .then(function () { return null; })
            .catch(this.handleError);
    };
    CartService.prototype.addProductToCart = function (product) {
        var userId = this.homeService.getLoggedInUserId();
        CartService_1.products.push(product);
        console.log(CartService_1.products);
        this.productsUrl = 'http://localhost:8080/shoppinghibernate/rest/user/add';
        return this.http
            .post(this.productsUrl, JSON.stringify({ userId: userId, productId: product.id }), { headers: this.headers })
            .toPromise()
            .then(function (res) { return res.json(); })
            .catch(this.handleError);
    };
    CartService.prototype.handleError = function (error) {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    };
    return CartService;
}());
CartService.products = [];
CartService = CartService_1 = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http, homeService_1.HomeService])
], CartService);
exports.CartService = CartService;
var CartService_1;
//# sourceMappingURL=CartService.js.map