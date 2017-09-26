import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';

import { AppComponent }  from './app.component';
import {ProductComponent} from './Component/products/product.component';
import{FormsModule} from '@angular/forms';
import{ProductService} from './Component/products/product-service';
import { ProductAppComponent }        from './Component/products/app.component';
import { RouterModule }   from '@angular/router';
import {DashboardComponent} from './Component/products/dashboard.component';
import {ContactUsComponent} from './Component/products/contact-us.component';
import {ProductDetailComponent} from './Component/products/product-detail-component';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './Component/products/in-memory-data.service';
import { ProductDetailUpdateComponent }  from './Component/products/product-detail-update.component';
import { ProductAddComponent }  from './Component/products/add-product.component';
import { ProductDeleteComponent }  from './Component/products/delete-product.component';
import { ProductSearchComponent }  from './Component/products/product-search.component';
import { CartComponent }  from './Component/products/cart.component';
import {CartService}   from './Component/products/CartService';





@NgModule({
  imports:      [ BrowserModule,FormsModule,HttpModule,InMemoryWebApiModule.forRoot(InMemoryDataService),RouterModule.forRoot([
    {
      path: 'products',
      component: ProductComponent
    },
    {
      path: 'cart',
      component: CartComponent
    },
    {
      path: 'dashboard',
      component: DashboardComponent
    },
    {
      path: 'contact-us',
      component: ContactUsComponent
    },
    {
      path: 'update/:id',
      component: ProductDetailUpdateComponent
      
    },
    {
      path: 'add',
      component: ProductAddComponent
      
    },
    {
      path: '',
      redirectTo: '/dashboard',
      pathMatch: 'full'
    },
    {
      path: 'detail/:id',
      component: ProductDetailComponent
    },
    {
      path: 'delete/:id',
      component: ProductDeleteComponent
    },

  ]),],
  declarations: [ AppComponent,ProductComponent,ProductAppComponent,DashboardComponent,ProductSearchComponent,CartComponent,ContactUsComponent,ProductDetailComponent,ProductAddComponent,ProductDetailUpdateComponent,ProductDeleteComponent],
  bootstrap:    [ ProductAppComponent ],
  providers:    [ProductService, CartService ]
})


export class AppModule { }
