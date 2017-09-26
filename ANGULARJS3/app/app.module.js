"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var http_1 = require("@angular/http");
var app_component_1 = require("./app.component");
var product_component_1 = require("./Component/products/product.component");
var forms_1 = require("@angular/forms");
var product_service_1 = require("./Component/products/product-service");
var app_component_2 = require("./Component/products/app.component");
var router_1 = require("@angular/router");
var dashboard_component_1 = require("./Component/products/dashboard.component");
var contact_us_component_1 = require("./Component/products/contact-us.component");
var product_detail_component_1 = require("./Component/products/product-detail-component");
var angular_in_memory_web_api_1 = require("angular-in-memory-web-api");
var in_memory_data_service_1 = require("./Component/products/in-memory-data.service");
var product_detail_update_component_1 = require("./Component/products/product-detail-update.component");
var add_product_component_1 = require("./Component/products/add-product.component");
var delete_product_component_1 = require("./Component/products/delete-product.component");
var product_search_component_1 = require("./Component/products/product-search.component");
var cart_component_1 = require("./Component/products/cart.component");
var CartService_1 = require("./Component/products/CartService");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [platform_browser_1.BrowserModule, forms_1.FormsModule, http_1.HttpModule, angular_in_memory_web_api_1.InMemoryWebApiModule.forRoot(in_memory_data_service_1.InMemoryDataService), router_1.RouterModule.forRoot([
                {
                    path: 'products',
                    component: product_component_1.ProductComponent
                },
                {
                    path: 'cart',
                    component: cart_component_1.CartComponent
                },
                {
                    path: 'dashboard',
                    component: dashboard_component_1.DashboardComponent
                },
                {
                    path: 'contact-us',
                    component: contact_us_component_1.ContactUsComponent
                },
                {
                    path: 'update/:id',
                    component: product_detail_update_component_1.ProductDetailUpdateComponent
                },
                {
                    path: 'add',
                    component: add_product_component_1.ProductAddComponent
                },
                {
                    path: '',
                    redirectTo: '/dashboard',
                    pathMatch: 'full'
                },
                {
                    path: 'detail/:id',
                    component: product_detail_component_1.ProductDetailComponent
                },
                {
                    path: 'delete/:id',
                    component: delete_product_component_1.ProductDeleteComponent
                },
            ]),],
        declarations: [app_component_1.AppComponent, product_component_1.ProductComponent, app_component_2.ProductAppComponent, dashboard_component_1.DashboardComponent, product_search_component_1.ProductSearchComponent, cart_component_1.CartComponent, contact_us_component_1.ContactUsComponent, product_detail_component_1.ProductDetailComponent, add_product_component_1.ProductAddComponent, product_detail_update_component_1.ProductDetailUpdateComponent, delete_product_component_1.ProductDeleteComponent],
        bootstrap: [app_component_2.ProductAppComponent],
        providers: [product_service_1.ProductService, CartService_1.CartService]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map