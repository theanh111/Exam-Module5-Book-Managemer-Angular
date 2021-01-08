import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';
import {ReactiveFormsModule} from '@angular/forms';
import { AddComponent } from './add/add.component';
import {HttpClientModule} from '@angular/common/http';
import { ListUserComponent } from './list-user/list-user.component';
import { DeleteComponent } from './delete/delete.component';
import {RouterModule} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    ListCustomerComponent,
    AddComponent,
    ListUserComponent,
    DeleteComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
