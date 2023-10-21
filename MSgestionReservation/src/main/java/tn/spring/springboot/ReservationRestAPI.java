package tn.spring.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationRestAPI {
    private String title="Hello, i'm the candidate Micro Service";

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println(title);
        return  title;
    }

    @Autowired
    private ReservationService reservationService;

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Reservation>> getReservations() {
        return new ResponseEntity<>(reservationService.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") int id,
                                                   @RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationService.updateReservation(id, reservation), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReservation(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(reservationService.deleteReservation(id), HttpStatus.OK);
    }

}
