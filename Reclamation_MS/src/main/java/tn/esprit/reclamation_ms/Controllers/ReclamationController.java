package tn.esprit.reclamation_ms.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.reclamation_ms.Entities.Reclamation;
import tn.esprit.reclamation_ms.Entities.Status;
import tn.esprit.reclamation_ms.Interfaces.IReclamation;
import java.util.List;

@RestController
@RequestMapping("/Reclamation")
public class ReclamationController {
    @Autowired
    IReclamation iReclamation;
    @PostMapping("/createReclamation")
    public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation) {
        return iReclamation.createReclamation(reclamation);
    }
    @DeleteMapping("/deleteReclamation/{id}")
    public ResponseEntity<HttpStatus> deleteReclamation(@PathVariable("id") Long id) {
        return iReclamation.deleteReclamation(id);
    }
    @PutMapping("/updateReclamation/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable("id")Long id, @RequestBody Reclamation reclamation) {
        return iReclamation.updateReclamation(id,reclamation);
    }
    @GetMapping("/getAllReclamations")
    //@RolesAllowed("admin")
    public ResponseEntity<List<Reclamation>> getAllReclamations() {
        return iReclamation.getAllReclamations();
    }
    @GetMapping("/getAllReclamationsByStatus/{status}")
    public ResponseEntity<List<Reclamation>> getAllReclamationsByStatus(@PathVariable("status") Status status) {
        return iReclamation.getAllReclamationsByStatus(status);
    }
    @GetMapping("/countAllByStatus/{status}")
    public ResponseEntity<Integer> countAllByStatus(@PathVariable("status")Status status) {
        return iReclamation.countAllByStatus(status);
    }
}
