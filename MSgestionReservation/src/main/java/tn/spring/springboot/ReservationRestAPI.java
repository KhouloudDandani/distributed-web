package tn.spring.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reservation> createCandidat(@RequestBody Reservation candidat) {
        return new ResponseEntity<>(reservationService.addReservation(candidat), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reservation> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Reservation candidat){
        return new ResponseEntity<>(reservationService.updateReservation(id, candidat), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(reservationService.deleteReservation(id), HttpStatus.OK);
    }

}
