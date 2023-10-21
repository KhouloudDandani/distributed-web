import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { ReservationComponent } from './pages/reservation/reservation.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  {
    path: "", component: MainLayoutComponent, children : [
      {path: "", component: HomeComponent},
      {path: "book", component: ReservationComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
