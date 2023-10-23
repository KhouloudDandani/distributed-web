import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLayoutComponent } from './layout/admin-layout/admin-layout.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ReservationListComponent } from './pages/reservation-list/reservation-list.component';

const routes: Routes = [
  {
    path: "" , component : AdminLayoutComponent, children : 
    [
      { path: "dashboard", component: DashboardComponent },
      { path: "reservations", component: ReservationListComponent },
      { path: "**", redirectTo: '/admin/dashboard' }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
