import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminLayoutComponent } from './layout/admin-layout/admin-layout.component';
import { AdminHeaderComponent } from './layout/admin-header/admin-header.component';
import { AdminFooterComponent } from './layout/admin-footer/admin-footer.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { SideBarComponent } from './layout/side-bar/side-bar.component';
import { FixedPluginComponent } from './layout/fixed-plugin/fixed-plugin.component';
import { ToastrModule } from 'ngx-toastr';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReservationListComponent } from './pages/reservation-list/reservation-list.component';


@NgModule({
  declarations: [
    AdminLayoutComponent,
    AdminHeaderComponent,
    AdminFooterComponent,
    DashboardComponent,
    SideBarComponent,
    FixedPluginComponent,
    ReservationListComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ToastrModule.forRoot(),
    NgbModule
  ]
})
export class AdminModule { }
