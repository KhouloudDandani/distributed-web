package tn.spring.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.repo.ReservationRepository;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation updateReservation(long id, Reservation newReservation) {
        if (reservationRepository.findById(id).isPresent()) {
            Reservation existingReservation = reservationRepository.findById(id).get();
            existingReservation.setNom(newReservation.getNom());
            existingReservation.setDateReservation(newReservation.getDateReservation());

            return reservationRepository.save(existingReservation);
        } else
            return null;
    }

    public String deleteReservation(long id) {
        if (reservationRepository.findById(id).isPresent()) {
            reservationRepository.deleteById(id);
            return "reservation supprimé";
        } else
            return "reservation non supprimé";
    }
}
