import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Reservation } from 'src/app/shared/models/Reservation.model';
import { ReservationService } from 'src/app/shared/services/reservation.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent implements OnInit, OnDestroy {

  listReservationSubscription: Subscription | undefined;
  reservation: Reservation = {
    id: 0,
    nom: "Khouloud",
    dateReservation: null,
    checkInDate: new Date(),
    checkOutDate: new Date(),
    adultsNumbers: 1,
    childrenNumbers: 0,
    phoneNumber: "2111",
  }
  isLoading: boolean = false;

  numberOfVistors: Array<number> = Array.from({length: 5}, (_, i) => i + 1)
  numberOfChildren: Array<number> = Array.from({length: 5}, (_, i) => i)

  constructor(
    private _reservationService: ReservationService
  ) { }

  ngOnInit(): void {
    this.getReservations();
  }

  ngOnDestroy(): void {
    this.listReservationSubscription?.unsubscribe();
  }


  createReservation() {
    this.isLoading = true;

    this.reservation.id=undefined;
    delete this.reservation.id;
    this.reservation.dateReservation = new Date();

    this._reservationService.createReservation(this.reservation).subscribe(
      res=> {
        console.log(res);
        this.isLoading = false;
        alert("Reservation created successfully")
      },
      err=> {
        console.log(err);
        
      }
    )
    
  }


  private getReservations() {
    this.listReservationSubscription = this._reservationService.getAllReservations().subscribe(
      res => {
        console.log(res);

      },
      err => {
        console.log(err);

      }
    )
  }
}
