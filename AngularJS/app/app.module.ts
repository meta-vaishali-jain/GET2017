import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent }  from './app.component';
import {ProductComponent} from './Component/products/product.component';
import{FormsModule} from '@angular/forms';
import{ProductService} from './Component/products/product-service'

@NgModule({
  imports:      [ BrowserModule,FormsModule],
  declarations: [ AppComponent,ProductComponent ],
  bootstrap:    [ ProductComponent ],
  providers:    [ProductService]
})
export class AppModule { }
