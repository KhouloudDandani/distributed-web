package tn.esprit.reclamation_ms.Interfaces;

import org.springframework.http.ResponseEntity;
import tn.esprit.reclamation_ms.Entities.Discussion;

import java.util.List;

public interface IDiscussion {
    ResponseEntity<Discussion> createDiscussion(Discussion discussion , Long id);
    ResponseEntity<List<Discussion>> getAllByReclamation (Long id);
}
