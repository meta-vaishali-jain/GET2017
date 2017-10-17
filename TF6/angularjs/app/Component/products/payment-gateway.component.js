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
var router_1 = require("@angular/router");
var OrderDetails_1 = require("./OrderDetails");
var PaymentDetails_1 = require("./PaymentDetails");
var checkoutService_1 = require("./checkoutService");
var PaymentGatewayComponent = (function () {
    function PaymentGatewayComponent(router, checkoutService) {
        this.router = router;
        this.checkoutService = checkoutService;
    }
    PaymentGatewayComponent.prototype.ngOnInit = function () {
        this.paymentId = new PaymentDetails_1.PaymentDetails();
        this.orderDetails = new OrderDetails_1.OrderDetails();
        this.finalPrice = +localStorage.getItem('finalPrice');
    };
    PaymentGatewayComponent.prototype.checkCardNumber = function (cardNumber) {
        var cardno = /^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$/;
        if (cardNumber.match(cardno)) {
            return true;
        }
        else {
            alert("Not a valid Amercican Express credit card number!");
            return false;
        }
    };
    PaymentGatewayComponent.prototype.checkMonth = function (expiryMonth) {
        var month = /^(0?[1-9]|1[012])$/;
        if (expiryMonth.match(month)) {
            return true;
        }
        else {
            alert("Enter valid month");
            return false;
        }
    };
    PaymentGatewayComponent.prototype.checkYear = function (expiryYear) {
        var year = /^[0-9]{2}$/;
        if (expiryYear.match(year)) {
            return true;
        }
        else {
            alert("Enter valid year");
            return false;
        }
    };
    PaymentGatewayComponent.prototype.checkCvvCode = function (cvCode) {
        var code = /^[0-9]{3,4}$/;
        if (cvCode.match(code)) {
            return true;
        }
        else {
            alert("Enter valid code");
            return false;
        }
    };
    PaymentGatewayComponent.prototype.savePaymentDetails = function (cardNumber, expiryMonth, expiryYear, cvCode) {
        if (this.checkCardNumber(cardNumber) && this.checkMonth(expiryMonth.toString()) && this.checkYear(expiryYear.toString()) && this.checkCvvCode(cvCode)) {
            this.paymentId.cardNumber = cardNumber;
            this.paymentId.expiryMonth = expiryMonth;
            this.paymentId.expiryYear = expiryYear;
            this.paymentId.userId = +localStorage.getItem('userId');
            this.orderDetails.orderDate = new Date();
            this.orderDetails.finalPrice = this.finalPrice;
            this.orderDetails.paymentId = this.paymentId;
            console.log(this.paymentId.cardNumber);
            console.log(this.orderDetails.paymentId.cardNumber);
            this.checkoutService.savePaymentDetails(this.orderDetails);
            this.mainComponent.ngOnInit();
            this.router.navigate(['main/products']);
        }
        else {
        }
    };
    return PaymentGatewayComponent;
}());
PaymentGatewayComponent = __decorate([
    core_1.Component({
        selector: 'payment-gateway',
        templateUrl: "./payment-gateway.html",
        styleUrls: ['./payment-gateway.css'],
    }),
    __metadata("design:paramtypes", [router_1.Router,
        checkoutService_1.CheckoutService])
], PaymentGatewayComponent);
exports.PaymentGatewayComponent = PaymentGatewayComponent;
//# sourceMappingURL=payment-gateway.component.js.map