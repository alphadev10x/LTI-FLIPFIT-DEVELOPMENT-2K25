import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookSlotComponent } from './componenets/book-slot/book-slot.component';
import { LoginComponent } from './componenets/login/login.component';
import { RegisterComponent } from './componenets/register/register.component';
import { AddCenterComponent } from './componenets/add-center/add-center.component';
import { LandingComponent } from './componenets/landing/landing.component';
import { GymAdminComponent } from './componenets/gym-admin/gym-admin.component';
import { GymOwnerComponent } from './componenets/gym-owner/gym-owner.component';
import { PageNotFoundComponent } from './componenets/page-not-found/page-not-found.component';
import { CustomerComponent } from './componenets/customer/customer.component';

const routes: Routes = [
  {path: "", component: LandingComponent},
  {path: 'bookslot', component: BookSlotComponent},
  {path: "center/addcenter", component: AddCenterComponent},
  {path: "register", component: RegisterComponent},
  {path: "admin", component: GymAdminComponent},
  {path: "owner", component: GymOwnerComponent},
  {path: "login", component: LoginComponent},
  { path: 'customer', component: CustomerComponent },
  // { path: 'booking', component: BookingComponent },
  { path: 'notifications', component: GymAdminComponent },
  { path: 'slot-booking', component: BookSlotComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
