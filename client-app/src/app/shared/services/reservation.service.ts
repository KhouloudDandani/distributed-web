import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private readonly url = `${environment.API_URL}/reservations/`;

  constructor(
    private http: HttpClient
  ) { }


  public getAllReservations (): Observable<any[]> {
    return this.http.get<any[]>(this.url);
  }

  public createReservation (reservation: any) {
    return this.http.post(this.url, reservation);
  }
}
