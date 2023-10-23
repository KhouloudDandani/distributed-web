package tn.esprit.reclamation_ms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.reclamation_ms.Entities.Discussion;
import tn.esprit.reclamation_ms.Entities.Reclamation;

import java.util.List;
@Repository
public interface DiscussionRepository extends JpaRepository<Discussion,Long> {
    List<Discussion> findAllByReclamationOrderByDate(Reclamation reclamation);
}
