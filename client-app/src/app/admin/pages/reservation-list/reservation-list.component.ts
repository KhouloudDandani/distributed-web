import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ReservationService } from 'src/app/shared/services/reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.scss']
})
export class ReservationListComponent implements OnInit , OnDestroy {
  listReservationSubscription: Subscription | undefined;
  list: any[] = [];
  constructor(
    private _reservationService: ReservationService
  ) { }


  ngOnInit(): void {
    this.getReservations();
  }

  ngOnDestroy(): void {
    this.listReservationSubscription?.unsubscribe();
  }


  private getReservations() {
    this.listReservationSubscription = this._reservationService.getAllReservations().subscribe(
      res => {
        console.log(res);
        this.list=res; 
      },
      err => {
        console.log(err);

      }
    )
  }

}
