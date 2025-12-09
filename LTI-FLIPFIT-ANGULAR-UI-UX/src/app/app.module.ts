import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './componenets/login/login.component';
import { RegisterComponent } from './componenets/register/register.component';
import { GymAdminComponent } from './componenets/gym-admin/gym-admin.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { AddCenterComponent } from './componenets/add-center/add-center.component';
import { BookSlotComponent } from './componenets/book-slot/book-slot.component';
import { LandingComponent } from './componenets/landing/landing.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { GymOwnerComponent } from './componenets/gym-owner/gym-owner.component';
import { PageNotFoundComponent } from './componenets/page-not-found/page-not-found.component';
import { SidebarMenuComponent } from './componenets/sidebar-menu/sidebar-menu.component';
import { CommonModule } from '@angular/common';
import { CustomerComponent } from './componenets/customer/customer.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    GymAdminComponent,
    AddCenterComponent,
    BookSlotComponent,
    LandingComponent,
    GymOwnerComponent,
    PageNotFoundComponent,
    SidebarMenuComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
    AppRoutingModule,
    RouterModule
],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
