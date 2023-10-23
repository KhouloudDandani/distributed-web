package tn.esprit.reclamation_ms.Interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.reclamation_ms.Entities.Reclamation;
import tn.esprit.reclamation_ms.Entities.Status;

import java.util.List;

public interface IReclamation {
    ResponseEntity<Reclamation> createReclamation(Reclamation reclamation);
    ResponseEntity<HttpStatus>deleteReclamation(Long id);
    ResponseEntity<Reclamation>updateReclamation(Long id,Reclamation reclamation);
    ResponseEntity<List<Reclamation>>getAllReclamations();
    ResponseEntity<List<Reclamation>> getAllReclamationsByStatus(Status status);
    ResponseEntity<Integer> countAllByStatus(Status status);

    interface IDiscussion {
    }
}
