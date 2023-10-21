export interface Reservation {
    id: number
    nom: string | undefined
    dateReservation: Date | undefined
    checkInDate: Date | undefined
    checkOutDate: Date | undefined
    adultsNumbers: number | undefined
    childrenNumbers: number | undefined
    phoneNumber: string | undefined
  }