package tn.esprit.reclamation_ms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.reclamation_ms.Entities.Reclamation;
import tn.esprit.reclamation_ms.Entities.Status;

import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
    int countAllByStatus( Status status);
    List<Reclamation> findAllByStatus(Status status);
}
