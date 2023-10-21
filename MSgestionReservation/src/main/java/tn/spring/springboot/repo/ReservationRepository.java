package tn.spring.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // ...
}